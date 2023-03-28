package com.company.jwt_token_2.repository;

import com.company.jwt_token_2.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRep extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
