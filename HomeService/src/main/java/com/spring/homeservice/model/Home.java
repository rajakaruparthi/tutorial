package com.spring.homeservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Home")
public class Home {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String name;
	private String password;

	public Home() {

	}

	@Override
	public String toString() {
		return "Home [id=" + id + ", name=" + name + ", password=" + password + "]";
	}

	public Home(String name, String password) {
		this.name = name;
		this.password = password;
	}

	public Home(Integer id, String name, String password) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
