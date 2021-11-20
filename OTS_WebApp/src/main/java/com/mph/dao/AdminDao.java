package com.mph.dao;

import java.util.List;

import com.mph.entity.Admin;
public interface AdminDao {
	
	public List<Admin> getAdminList();
	public Admin getAdmin(Admin admin);
	public void createAdmin(Admin admin);
	public void updateAdmin(Admin admin);
	public List<Admin> deleteAdmin(int adid);
	public Admin getAdminID(int adid);
	public List<Admin> searchAdminById(int adid);

}
