package com.company.jwt_token_2.repository;

import com.company.jwt_token_2.models.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRep extends JpaRepository<Bill, Long> {
}
