package com.spring.hospital.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Address {

	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE)
	@Column(name="ua_id")
	private Integer ua_id;
	private String address_line_1;
	private String address_line_2;
	private String state;
	private String city;
	private String zipcode;
	private String phone;

//	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	@JoinColumn(name="ua_id", referencedColumnName="user_id")
//	private User user;

	public Address() {

	}

	public Address(int ua_id, String address_line_1, String address_line_2, String state, String city, String zipcode,
			String phone) {
		this.ua_id = ua_id;
		this.address_line_1 = address_line_1;
		this.address_line_2 = address_line_2;
		this.state = state;
		this.city = city;
		this.zipcode = zipcode;
		this.phone = phone;
	}

	public Integer getUa_id() {
		return ua_id;
	}

	public void setUa_id(Integer ua_id) {
		this.ua_id = ua_id;
	}

	public String getAddress_line_1() {
		return address_line_1;
	}

	public void setAddress_line_1(String address_line_1) {
		this.address_line_1 = address_line_1;
	}

	public String getAddress_line_2() {
		return address_line_2;
	}

	public void setAddress_line_2(String address_line_2) {
		this.address_line_2 = address_line_2;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
