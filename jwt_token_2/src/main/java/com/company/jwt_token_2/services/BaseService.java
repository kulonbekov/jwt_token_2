package com.company.jwt_token_2.services;

import java.util.List;

public interface BaseService <Dto>{

    Dto save(Dto dto);
    Dto findById(Long id);
    List<Dto> findAll();
    Dto delete(Long id);
}
