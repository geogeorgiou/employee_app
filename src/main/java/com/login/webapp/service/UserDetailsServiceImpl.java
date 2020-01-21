package com.login.webapp.service;

import com.login.webapp.domain.LoginUser;
import com.login.webapp.model.LoginResponse;
import com.login.webapp.repository.LoginUserRepository;
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
    LoginUserRepository loginUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // here we would search into the repo for the user.
        // for not we are just going to send always a successful response.

        Optional<LoginUser> loginUser = loginUserRepository.findByEmail(username);

        if (loginUser.isEmpty()) {
            throw new UsernameNotFoundException("the user with email could not be found");
        }
        LoginUser user = loginUser.get();

        return new LoginResponse(
                user.getEmail(),
                user.getPassword(),
                List.of(new SimpleGrantedAuthority(user.getRole().name())),
                user
        );


    }

}
