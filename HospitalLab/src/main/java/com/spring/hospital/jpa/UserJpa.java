package com.spring.hospital.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.spring.hospital.model.User;

@EnableJpaRepositories
public interface UserJpa extends JpaRepository<User, Integer> {

}
