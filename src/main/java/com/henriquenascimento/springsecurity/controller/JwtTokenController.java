package com.henriquenascimento.springsecurity.controller;

import com.henriquenascimento.springsecurity.dto.JwtTokenRequestDTO;
import com.henriquenascimento.springsecurity.dto.JwtTokenResponseDTO;
import com.henriquenascimento.springsecurity.service.JwtTokenService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(JwtTokenController.BASE_URI)
@RequiredArgsConstructor
public class JwtTokenController {

    public static final String BASE_URI = "/jwt-token";
    public static final String LOGIN_URI = "/login";
    private final JwtTokenService jwtTokenService;

    @PostMapping(LOGIN_URI)
    public ResponseEntity<JwtTokenResponseDTO> getJwtToken(@RequestBody final JwtTokenRequestDTO jwtTokenRequestDTO) {
        return ResponseEntity.ok(jwtTokenService.getJwtToken(jwtTokenRequestDTO));
    }

}
