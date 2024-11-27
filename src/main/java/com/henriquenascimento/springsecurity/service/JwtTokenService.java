package com.henriquenascimento.springsecurity.service;

import com.henriquenascimento.springsecurity.dto.JwtTokenRequestDTO;
import com.henriquenascimento.springsecurity.dto.JwtTokenResponseDTO;
import com.henriquenascimento.springsecurity.entities.Role;
import com.henriquenascimento.springsecurity.properties.JwtProperties;
import com.henriquenascimento.springsecurity.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
public class JwtTokenService {

    private final JwtEncoder jwtEncoder;
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final JwtProperties jwtProperties;

    public JwtTokenResponseDTO getJwtToken(final JwtTokenRequestDTO jwtTokenRequestDTO) {
        var user = userRepository.findByUsername(jwtTokenRequestDTO.username());
        if (user.isEmpty() || !user.get().isLoginCorrect(jwtTokenRequestDTO, passwordEncoder)) {
            throw new BadCredentialsException("User or password is invalid!");
        }

        var now = Instant.now();
        var expiresIn = jwtProperties.getExpiresIn();
        var scopes = user.get().getRoles()
                .stream()
                .map(Role::getName)
                .collect(Collectors.joining(" "));

        var claims = JwtClaimsSet.builder()
                .issuer(jwtProperties.getIssuer())
                .subject(user.get().getUserId().toString())
                .issuedAt(now)
                .expiresAt(now.plusSeconds(expiresIn))
                .claim("scope", scopes)
                .build();

        return new JwtTokenResponseDTO(
                jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue(),
                expiresIn);
    }
}
