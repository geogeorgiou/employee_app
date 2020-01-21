package com.login.employee.repository;

import com.login.employee.domain.LoginUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LoginUserRepository extends JpaRepository<LoginUser, String> {

    //Using Spring JPA functionality to get DB Data
    Optional<LoginUser> findByEmail(String email);

}
