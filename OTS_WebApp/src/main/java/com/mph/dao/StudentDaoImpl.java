package com.mph.dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Repository;


import com.mph.entity.Student;

@Repository
public class StudentDaoImpl  implements StudentDao {

	
	@Autowired
	private SessionFactory sessionFactory;
	
	protected Session getSession()
	{
		return sessionFactory.getCurrentSession();
	}
	
	
	
	@Override
	public List<Student> getStudentList() {
		Query qry=getSession().createQuery("from Student");
		List<Student> emplist=qry.list();
		return emplist;
	}

	@Override
	public Student getStudent(Student student) {
		Criteria c=getSession().createCriteria(Student.class);
		c.add(Restrictions.eq("st_email",student.getSt_email()));
		c.add(Restrictions.eq("st_password",student.getSt_password()));
		Student stu =(Student)c.uniqueResult();
		return stu;
		
	}

	@Override
	public void createStudent(Student student) {
		System.out.println("step2");
		getSession().save(student);
		System.out.println("step3");
		System.out.println("Student data stored successfully...");
		
	}

	@Override
	public void updateStudent(Student student) {
		
			Student stu = getStudentID(student.getSt_id()); 
			
			stu.setSt_firstName(student.getSt_firstName());
			stu.setSt_lastName(student.getSt_lastName());
			stu.setSt_email(student.getSt_email());
			stu.setSt_password(student.getSt_password());
			stu.setSt_gender(student.getSt_gender());
			stu.setSt_contact(student.getSt_contact());
			stu.setDob(student.getDob());
			getSession().update(stu);
		
		
//		Query qry=getSession().createQuery("update Student set fname=:fnam,lname=:lnam,email=:email,password=:pass,gender=:gender,contact=:cont where eid=:eno");
//		qry.setParameter("fnam", student.getSt_name().getFirstName());
//		qry.setParameter("lnam", student.getSt_name().getLastName());
//		qry.setParameter("email", student.getSt_email());
//		qry.setParameter("pass",student.getSt_password());
//		qry.setParameter("gender", student.getSt_password());
//		qry.setParameter("cont", student.getSt_contact());
//		qry.setParameter("eno", student.getSt_id());
//		List<Student> stulist=qry.list();
//		return stulist;
	
	}

	@Override
	public List<Student> deleteStudent(int stid) {
		Query qry=getSession().createQuery("delete Student where st_id=:eno");
		qry.setParameter("eno", stid);
		int noofrows=qry.executeUpdate();
		if(noofrows >0)
		{
			System.out.println("deleted successfully...");
		}
		return getStudentList();
	}

	@Override
	public Student getStudentID(int stid) {
		Query qry =getSession().createQuery("from Student stu where st_id=:eno");
		qry.setParameter("eno",stid);
		
		Student stulist=(Student)qry.uniqueResult();
		System.out.println(stulist);
		return stulist;
	}

	@Override
	public List<Student> searchStudentById(int stid) {
		Query query = getSession().createQuery("from Student stu where st_id=:eno");
		query.setParameter("eno", stid);
		List<Student> stulist =query.list();
		System.out.println(stulist);
		return stulist;
	}



	@Override
	public Student getStudentEmail(String email) {
		Query qry =getSession().createQuery("from Student stu where st_email=:eno");
		qry.setParameter("eno",email);
		
		Student stulist=(Student)qry.uniqueResult();
		System.out.println(stulist);
		return stulist;
	}

}
