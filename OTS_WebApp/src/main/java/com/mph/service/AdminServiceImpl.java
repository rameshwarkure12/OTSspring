package com.mph.service;

import java.util.List;

import com.mph.entity.Admin;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mph.dao.AdminDao;


@Service
@Transactional
public class AdminServiceImpl implements AdminService{

	@Autowired
	AdminDao adminDao;
	
	public List<Admin> getAdminList() {
		
		return adminDao.getAdminList();
	}

	public Admin getAdmin(Admin admin) {

		return adminDao.getAdmin(admin);
	}

	public void createAdmin(Admin admin) {

		adminDao.createAdmin(admin);
		
	}

	public void updateAdmin(Admin admin) {

		adminDao.updateAdmin(admin);
	}

	public List<Admin> deleteAdmin(int adid) {

		return adminDao.deleteAdmin(adid);
	}

	public Admin getAdminID(int adid) {

		return adminDao.getAdminID(adid);
	}

	public List<Admin> searchAdminById(int adid) {

		return adminDao.searchAdminById(adid);
	}

}
