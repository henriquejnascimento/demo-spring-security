package com.henriquenascimento.springsecurity.service;

import com.henriquenascimento.springsecurity.dto.UserRequestDTO;
import com.henriquenascimento.springsecurity.dto.UserResponseDTO;
import com.henriquenascimento.springsecurity.entities.User;
import com.henriquenascimento.springsecurity.enumerator.RoleType;
import com.henriquenascimento.springsecurity.mapper.UserResponseMapper;
import com.henriquenascimento.springsecurity.repository.RoleRepository;
import com.henriquenascimento.springsecurity.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Set;

@Service
@Log4j2
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final UserResponseMapper userResponseMapper;

    public UserResponseDTO save(final UserRequestDTO dto) {
        var basicRole = roleRepository.findByName(RoleType.BASIC.name());
        var userFromDb = userRepository.findByUsername(dto.username());
        if (userFromDb.isPresent()) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);
        }
        return userResponseMapper.toDTO(
                userRepository.save(
                        User.builder()
                                .username(dto.username())
                                .password(passwordEncoder.encode(dto.password()))
                                .roles(Set.of(basicRole))
                                .build()));
    }

    public List<UserResponseDTO> listUsers() {
        return userResponseMapper.toListDTO(
                userRepository.findAll());
    }

}
