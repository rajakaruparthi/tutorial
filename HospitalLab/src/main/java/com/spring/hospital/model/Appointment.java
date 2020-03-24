package com.spring.hospital.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Appointment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "apt_id")
	private int id;
	private String aptReason;
	private String aptTime;
	
	@Column(name = "user_id")
	private String user_id;

	public Appointment(String aptReason, String aptTime, String user_id) {
		this.aptReason = aptReason;
		this.aptTime = aptTime;
		this.user_id = user_id;
	}

	public Appointment() {
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAptReason() {
		return aptReason;
	}

	public void setAptReason(String aptReason) {
		this.aptReason = aptReason;
	}

	public String getAptTime() {
		return aptTime;
	}

	public void setAptTime(String aptTime) {
		this.aptTime = aptTime;
	}

}
