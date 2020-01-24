package com.login.employee.repository;

import com.login.employee.domain.Attribute;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AttributeRepository extends JpaRepository<AttributeRepository, String> {


}
