package com.mph.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mph.entity.Admin;
import com.mph.entity.Student;

import org.springframework.stereotype.Repository;

import com.mph.entity.Admin;

@Repository
public class AdminDaoImpl implements AdminDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	protected Session getSession()
	{
		return sessionFactory.getCurrentSession();
	}
	
	
	
	@Override
	public List<Admin> getAdminList() {
		Query qry=getSession().createQuery("from Admin");
		List<Admin> emplist=qry.list();
		return emplist;
	}

	@Override
	public Admin getAdmin(Admin admin) {
		Criteria c=getSession().createCriteria(Admin.class);
		c.add(Restrictions.eq("admin_email",admin.getAdmin_email()));
		c.add(Restrictions.eq("admin_password",admin.getAdmin_password()));
		Admin stu =(Admin)c.uniqueResult();
		return stu;
		
	}

	@Override
	public void createAdmin(Admin admin) {
		getSession().save(admin);
		System.out.println("Student data stored successfully...");
		
	}

	@Override
	public void updateAdmin(Admin admin) {
		
		Admin stu = getAdminID(admin.getAdmin_id()); 
			
			stu.setAdmin_name(admin.getAdmin_name());
			stu.setAdmin_email(admin.getAdmin_email());
			stu.setAdmin_password(admin.getAdmin_password());
			
			getSession().update(stu);
		
		

	}

	@Override
	public List<Admin> deleteAdmin(int adid) {
		Query qry=getSession().createQuery("delete Admin where admin_id=:eno");
		qry.setParameter("eno", adid);
		int noofrows=qry.executeUpdate();
		if(noofrows >0)
		{
			System.out.println("deleted successfully...");
		}
		return getAdminList();
	}

	@Override
	public Admin getAdminID(int adid) {
		Query qry =getSession().createQuery("from Admin adm where admin_id=:eno");
		qry.setParameter("eno",adid);
		
		Admin stulist=(Admin)qry.uniqueResult();
		System.out.println(stulist);
		return stulist;
	}

	@Override
	public List<Admin> searchAdminById(int adid) {
		Query query = getSession().createQuery("from Admin adm where admin_id=:eno");
		query.setParameter("eno", adid);
		List<Admin> stulist =query.list();
		System.out.println(stulist);
		return stulist;
	}
}
