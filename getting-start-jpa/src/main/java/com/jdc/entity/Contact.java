package com.jdc.entity;

import java.io.Serializable;
import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Contact implements Serializable {

	private static final long serialVersionUID = 1L;
	@Column(table = "contact")
	private Date dob;
	@Column(table = "contact")
	private String phone;
	@Column(table = "contact")
	private String email;

	public Contact() {
		// TODO Auto-generated constructor stub
	}

	public Contact(Date dob, String phone, String email) {
		super();
		this.dob = dob;
		this.phone = phone;
		this.email = email;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
