package com.henriquenascimento.springsecurity.repository;

import com.henriquenascimento.springsecurity.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(final String name);
}
