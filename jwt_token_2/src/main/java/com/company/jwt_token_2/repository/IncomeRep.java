package com.company.jwt_token_2.repository;

import com.company.jwt_token_2.models.Income;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncomeRep extends JpaRepository<Income, Long> {
}
