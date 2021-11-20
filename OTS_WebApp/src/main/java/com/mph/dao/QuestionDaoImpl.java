package com.mph.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mph.entity.Question;
import com.mph.entity.Quiz;

@Repository
public class QuestionDaoImpl implements QuestionDao {

	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public List<Question> getQuestionList() {
		Query qry = getSession().createQuery("from Question");
		List<Question> emplist = qry.list();
		return emplist;

	}

	@Override
	public Question getQuestionById(int qid) {
		Query qry = getSession().createQuery("from Question que where question_id=:eno");
		qry.setParameter("eno", qid);

		Question stulist = (Question) qry.uniqueResult();
		System.out.println(stulist);
		return stulist;
	}

	@Override
	public List<Question> deleteQuestionById(int qid) {
		Query qry = getSession().createQuery("delete Question where question_id=:eno");
		qry.setParameter("eno", qid);
		int noofrows = qry.executeUpdate();
		if (noofrows > 0) {
			System.out.println("deleted successfully...");
		}
		return getQuestionList();

	}

	

	@Override
	public void addQuestion(Question question) {
		getSession().save(question);

		System.out.println("Subject data stored successfully...");
	}

	

	@Override
	public void updateQuestion(Question question) {
		Question stu = getQuestionById(question.getQuestion_id()); 
        
        stu.setQuestion_id(question.getQuestion_id());
        stu.setQdescription(question.getQdescription());
        stu.setOp1(question.getOp1());
        stu.setOp2(question.getOp2());
        stu.setOp3(question.getOp3());
        stu.setOp4(question.getOp4());
        stu.setAnswer(question.getAnswer());
        
       
        
        getSession().update(stu);

	}

	@Override
	public List<Question> getQuizID(int qid) {
		Query qry =getSession().createQuery("from Question qu where qid=:eno");
        qry.setParameter("eno",qid);
        
        List<Question> stulist=qry.list();
        System.out.println(stulist);
        return stulist;
	}
	}

	


