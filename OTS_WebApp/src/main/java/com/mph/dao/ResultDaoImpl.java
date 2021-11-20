package com.mph.dao;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mph.entity.Result;

@Repository
public class ResultDaoImpl implements ResultDao{

	 @Autowired
	    private SessionFactory sessionFactory;
	    
	    protected Session getSession()
	    {
	        return sessionFactory.getCurrentSession();
	    }
	
	
	@Override
	public List<Result> getResultList() {
		 Query qry=getSession().createQuery("from Result");
	        List<Result> emplist=qry.list();
	        return emplist;
	}

	@Override
	public void addResult(Result result) {
		   getSession().save(result);
	        
	        System.out.println("Student data stored successfully...");
	}

	@Override
	public List<Result> deleteResult(int rid) {
		 Query qry=getSession().createQuery("delete Result where result_id=:eno");
	        qry.setParameter("eno", rid);
	        int noofrows=qry.executeUpdate();
	        if(noofrows >0)
	        {
	            System.out.println("deleted successfully...");
	        }
	        return getResultList();
	}

	@Override
	public Result getResultID(int rid) {
		Query qry =getSession().createQuery("from Result rs where result_id=:eno");
        qry.setParameter("eno",rid);
        
        Result stulist=(Result)qry.uniqueResult();
        System.out.println(stulist);
        return stulist;
	}

	@Override
	public List<Result> searchResultById(int rid) {
	      Query query = getSession().createQuery("from Result rs where result_id=:eno");
	        query.setParameter("eno", rid);
	        List<Result> stulist =query.list();
	        System.out.println(stulist);
	        return stulist;
	    }

}
