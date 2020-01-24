package com.login.employee.service;

import com.login.employee.repository.AttributeRepository;

import java.util.Optional;

public interface AttributeService {

    Optional<AttributeRepository> findById(String id);
}
