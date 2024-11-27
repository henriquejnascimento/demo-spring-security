package com.henriquenascimento.springsecurity.controller;

import com.henriquenascimento.springsecurity.dto.UserRequestDTO;
import com.henriquenascimento.springsecurity.dto.UserResponseDTO;
import com.henriquenascimento.springsecurity.service.UserService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.henriquenascimento.springsecurity.constant.Constants.AUTHORITY_ADMIN;

@RestController
@RequestMapping(UserController.BASE_URI)
@RequiredArgsConstructor
public class UserController {

    public static final String BASE_URI = "/user";
    private final UserService userService;

    @Transactional
    @PostMapping
    public ResponseEntity<UserResponseDTO> newUser(@RequestBody final UserRequestDTO dto) {
        return ResponseEntity.ok(userService.save(dto));
    }

    @GetMapping
    @PreAuthorize("hasAuthority('" + AUTHORITY_ADMIN + "')")
    public ResponseEntity<List<UserResponseDTO>> listUsers() {
        return ResponseEntity.ok(userService.listUsers());
    }

}
