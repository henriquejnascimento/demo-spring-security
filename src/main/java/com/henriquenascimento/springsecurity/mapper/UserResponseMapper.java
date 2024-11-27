package com.henriquenascimento.springsecurity.mapper;

import com.henriquenascimento.springsecurity.dto.UserResponseDTO;
import com.henriquenascimento.springsecurity.entities.User;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserResponseMapper {

    UserResponseDTO toDTO(final User entity);

    List<UserResponseDTO> toListDTO(final List<User> entity);

    @Mapping(target = "password", ignore = true)
    User toEntity(final UserResponseDTO dto);

    List<User> toListEntity(final List<UserResponseDTO> dto);

}
