package com.home.test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.jdc.entity.Company;
import com.jdc.entity.Member;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MemberTest {

	static EntityManagerFactory emf;

	@BeforeAll
	static void init() {
		emf = Persistence.createEntityManagerFactory("jpa");
	}

	@AfterAll
	static void close() {
		if (null != emf && emf.isOpen()) {
			emf.close();
		}
	}

	@Test
	void test() {
		var company = new Company();
		company.setName("JDC");
		var member = new Member();
		member.setName("mg mg");
		var em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(member);
		em.persist(company);
		System.err.println(member.getId());
		System.err.println(company.getId());
		em.getTransaction().commit();
	}
}
