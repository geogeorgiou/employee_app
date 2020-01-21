package com.login.employee.service;

import com.login.employee.domain.Employee;
import com.login.employee.model.LoginResponse;
import com.login.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//Implementation of UserDetailsService that creates LoginResponse

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // here we would search into the repo for the user.
        // for not we are just going to send always a successful response.

        Optional<Employee> loginUser = employeeRepository.findByEmail(username);

        if (loginUser.isEmpty()) {
            throw new UsernameNotFoundException("the user with email could not be found");
        }
        Employee user = loginUser.get();

        return new LoginResponse(
                user.getEmail(),
                user.getPassword(),
                List.of(new SimpleGrantedAuthority(user.getRole().name())),
                user
        );


    }

}
