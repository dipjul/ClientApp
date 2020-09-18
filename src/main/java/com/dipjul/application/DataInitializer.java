package com.dipjul.application;

import com.dipjul.application.domain.User;
//import com.dipjul.application.domain.Client;
import com.dipjul.application.repository.UserRepository;
//import com.dipjul.application.repository.ClientRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Slf4j
public class DataInitializer implements CommandLineRunner {

//    @Autowired
//    ClientRepository clients;

    @Autowired
    UserRepository users;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {

//        this.users.save(User.builder()
//            .username("user")
//            .password(this.passwordEncoder.encode("password"))
//            .roles(Arrays.asList( "ROLE_USER"))
//            .build()
//        );
//
//        this.users.save(User.builder()
//            .username("admin")
//            .password(this.passwordEncoder.encode("password"))
//            .roles(Arrays.asList("ROLE_USER", "ROLE_ADMIN"))
//            .build()
//        );

        log.debug("printing all users...");
        this.users.findAll().forEach(v -> log.debug(" User :" + v.toString()));
    }
}
