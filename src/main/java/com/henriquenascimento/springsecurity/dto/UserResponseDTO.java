package com.henriquenascimento.springsecurity.dto;

import com.henriquenascimento.springsecurity.entities.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDTO {

    private UUID userId;
    private String username;
    private Set<Role> roles;

}
