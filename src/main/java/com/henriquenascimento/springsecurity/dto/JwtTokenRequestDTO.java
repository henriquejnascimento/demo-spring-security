package com.henriquenascimento.springsecurity.dto;

public record JwtTokenRequestDTO(
        String username,
        String password) {
}
