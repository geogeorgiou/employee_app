package com.login.employee.security;

import com.login.employee.authenticationhandler.LoginSuccessHandler;
import com.login.employee.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

//Security Config module to enable Security for the Webapp

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    //Define necessary variables for Security

    //handler for authentication success
    @Autowired
    private LoginSuccessHandler loginSuccessHandler;

    //bean for UserDetailsService
    @Bean
    public UserDetailsService userDetailsService(){ return new UserDetailsServiceImpl();}

//    bean for Password Encryption using BCryptEncoder
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    public PasswordEncoder passwordEncoder(){
//        return new PlainPasswordEncoder();
//    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.userDetailsService(userDetailsService())
                .passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http
                .csrf().disable()


                //LOGIN Configuration
                .formLogin()
                .loginPage("/login")
                .successHandler(loginSuccessHandler)
                .failureUrl("/login?error=true")



                //LOGOUT Configuration
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login")
//                .deleteCookies("JSESSIONID")
                .permitAll()
                .and()



                //AUTHORIZATION AND ROLES
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/login").anonymous()
                .antMatchers("/admin/**").hasAuthority("ADMIN")
                .antMatchers("/user/**").hasAuthority("USER")

                //ERROR HANDLING FOR ACCESS DENIED
                .and()
                .exceptionHandling().accessDeniedPage("/error/access-denied")



                .and()
                .headers()
                .frameOptions()
                .sameOrigin()
        ;
    }

}
