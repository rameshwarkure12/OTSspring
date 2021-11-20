package com.mph.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mph.entity.Subject;

@Repository
public class SubjectDaoImpl implements SubjectDao{
	
	  @Autowired
	    private SessionFactory sessionFactory;
	    
	    protected Session getSession()
	    {
	        return sessionFactory.getCurrentSession();
	    }
	
	
	
	@Override
	public List<Subject> getSubjectList() {
		Query qry=getSession().createQuery("from Subject");
        List<Subject> emplist=qry.list();
        return emplist;
	}

	@Override
	public Subject getSubject(Subject subject) {
		Criteria c=getSession().createCriteria(Subject.class);
        c.add(Restrictions.eq("subject_id",subject.getSubject_id()));
        
        Subject stu =(Subject)c.uniqueResult();
        return stu;
	}

	@Override
	public void createSubject(Subject subject) {
		getSession().save(subject);
        
        System.out.println("Subject data stored successfully...");
		
	}

	@Override
	public void updateSubject(Subject subject) {
	     Subject stu = getSubjectID(subject.getSubject_id()); 
         
         stu.setSubject_id(subject.getSubject_id());
         stu.setSubject_name(subject.getSubject_name());
        

         
         getSession().update(stu);
		
	}

	@Override
	public List<Subject> deleteSubject(int subid) {
		 Query qry=getSession().createQuery("delete Subject where subject_id=:eno");
	        qry.setParameter("eno", subid);
	        int noofrows=qry.executeUpdate();
	        if(noofrows >0)
	        {
	            System.out.println("deleted successfully...");
	        }
	        return getSubjectList();
	}

	@Override
	public Subject getSubjectID(int subid) {
		Query qry =getSession().createQuery("from Subject sub where subject_id=:eno");
        qry.setParameter("eno",subid);
        
        Subject stulist=(Subject)qry.uniqueResult();
        System.out.println(stulist);
        return stulist;
	}

	@Override
	public List<Subject> searchSubjectById(int subid) {
		 Query query = getSession().createQuery("from subject sub where subject_id=:eno");
	        query.setParameter("eno", subid);
	        List<Subject> stulist =query.list();
	        System.out.println(stulist);
	        return stulist;
	}

}
