package com.spring.docker.controller;

import javax.ws.rs.GET;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/dockerCtrl")
@RestController
public class DockerLearn {
	
	@GET
	@RequestMapping("/get")
	public String getName() {
		System.out.println("came in");
		return "this is test raja";
	}

}
