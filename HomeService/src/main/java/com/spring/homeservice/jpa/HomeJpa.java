package com.spring.homeservice.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.spring.homeservice.model.Home;

@EnableJpaRepositories
public interface HomeJpa extends JpaRepository<Home, Integer> {
	
	
}
