package com.mph.testcase;

import static org.junit.Assert.*;

import org.junit.Test;

import com.mph.entity.Admin;

public class AdminTest {

	@Test
	public void testSetAdminId() {
		Admin admin = new Admin();
		admin.setAdmin_id(1);
		assertTrue(admin.getAdmin_id() == 1);
	}

	@Test
	public void testSetAdminName() {
		Admin admin = new Admin();
		admin.setAdmin_name("Shiva");
		assertTrue(admin.getAdmin_name() == "Shiva");
	}

	@Test
	public void testSetAdminEmail() {
		Admin admin = new Admin();
		admin.setAdmin_email("a@a");
		assertTrue(admin.getAdmin_email() == "a@a");
	}

	@Test
	public void testSetAdminPassword() {
		Admin admin = new Admin();
		admin.setAdmin_password("pwd");
		assertTrue(admin.getAdmin_password() == "pd");
	}
	

}
