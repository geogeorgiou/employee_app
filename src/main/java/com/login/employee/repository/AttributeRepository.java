package com.login.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AttributeRepository extends JpaRepository<AttributeRepository, String> {

    Optional<AttributeRepository> findById(String id);
}
