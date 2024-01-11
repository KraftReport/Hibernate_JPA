package com.jdc.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.SecondaryTable;
import jakarta.persistence.Table;
import jakarta.persistence.TableGenerator;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(

		name = "member_table", indexes = { @Index(columnList = "name") })
@SecondaryTable(name = "login")
@SecondaryTable(name = "contact", uniqueConstraints = { @UniqueConstraint(columnNames = "email") })
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mem_seq")
	@TableGenerator(name = "mem_seq", initialValue = 100, allocationSize = 1)
	private int id;
	private String name;
	@Embedded
	private Contact contact;
	@Enumerated(EnumType.STRING)
	private role role;
	@Column(table = "login")
	private int loginId;
	@Column(table = "login")
	private int password;

	public Member() {
		// TODO Auto-generated constructor stub
	}

	public Member(String name, Contact contact, com.jdc.entity.Member.role role) {
		super();
		this.name = name;
		this.contact = contact;
		this.role = role;
	}

	public role getRole() {
		return role;
	}

	public void setRole(role role) {
		this.role = role;
	}

	public enum role {
		admin, teacher, student
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
