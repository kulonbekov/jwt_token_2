package com.company.jwt_token_2.repository;

import com.company.jwt_token_2.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRep extends JpaRepository<User, Long> {
    User findByUsername(String name);
}
