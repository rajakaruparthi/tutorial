package com.spring.hospital.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;
import com.spring.hospital.service.UserService;

@Configuration
public class JersyConfig extends ResourceConfig{
	
	public JersyConfig() {
		register(UserService.class);
	}

}
