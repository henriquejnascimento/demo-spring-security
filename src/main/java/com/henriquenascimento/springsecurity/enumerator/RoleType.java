package com.henriquenascimento.springsecurity.enumerator;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum RoleType {

    ADMIN(1L),
    BASIC(2L);

    private final Long roleId;

}