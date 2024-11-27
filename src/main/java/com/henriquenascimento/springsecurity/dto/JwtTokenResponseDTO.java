package com.henriquenascimento.springsecurity.dto;

public record JwtTokenResponseDTO(
        String accessToken,
        Long expiresIn) {
}
