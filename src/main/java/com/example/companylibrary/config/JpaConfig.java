package com.example.companylibrary.config;

import com.example.companylibrary.repository.jpa.JpaUserRepository;
import com.example.companylibrary.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@Configuration
public class JpaConfig {


    private final EntityManager em;

    public JpaConfig(EntityManager em){
        this.em = em;
    }

    @Bean
    public UserRepository userRepository() { return new JpaUserRepository(em); }
}
