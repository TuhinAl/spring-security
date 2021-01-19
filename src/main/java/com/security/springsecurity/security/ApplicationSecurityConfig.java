package com.security.springsecurity.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

//import static com.security.springsecurity.security.ApplicationUserRole.ADMIN;
//import static com.security.springsecurity.security.ApplicationUserRole.STUDENT;

import static com.security.springsecurity.security.ApplicationUserRole.*;

/**
 * @author Alauddin Tuhin
 * @created_on 1/18/21 at 2:55 PM
 * @project - springsecurity
 **/
@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public ApplicationSecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }


    /*@Override
    @Bean
    protected void configure(HttpSecurity http) throws Exception {
        http.
                authorizeRequests()
                .antMatchers("/")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }*/


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.
                authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/student/**").hasRole(STUDENT.name())
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        /*UserDetails user = User.builder()
                .username("cs")
                .password( passwordEncoder.encode("cs"))
                .roles("STUDENT")
                .build();*/


        UserDetails user = User.builder()
                .username("cs")
                .password( passwordEncoder.encode("cs"))
                .roles(STUDENT.name())
                .build();

        UserDetails admin = User.builder()
                .username("admin")
                .password( passwordEncoder.encode("admin"))
                .roles( ADMIN.name())
                .build();

        return new InMemoryUserDetailsManager(user,admin);
    }
}
