package com.mph.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mph.entity.Quiz;
import com.mph.entity.Subject;

@Repository
public class QuizDaoImpl implements QuizDao {

	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	
	

	public List<Quiz> getQuizList() {
		Query qry = getSession().createQuery("from Quiz");
		List<Quiz> emplist = qry.list();
		return emplist;
	}
	
	
	

	public Quiz getQuiz(Quiz quiz) {
		Criteria c = getSession().createCriteria(Quiz.class);
		c.add(Restrictions.eq("qid", quiz.getQid()));

		Quiz stu = (Quiz) c.uniqueResult();
		return stu;

	}

	public void createQuiz(Quiz quiz) {

		getSession().save(quiz);

		System.out.println("Quiz data stored successfully...");

	}

	public void updateQuiz(Quiz quiz) {

		Quiz stu = getQuizID(quiz.getQid());

		stu.setQid(quiz.getQid());
		stu.setTitle(quiz.getTitle());
		stu.setTest_date(quiz.getTest_date());
		stu.setMaxMarks(quiz.getMaxMarks());
		stu.setNumberOfQuestions(quiz.getNumberOfQuestions());

		getSession().update(stu);

	}

	public List<Quiz> deleteQuizById(int qid) {
		Query qry = getSession().createQuery("delete Quiz where qid=:eno");
		qry.setParameter("eno", qid);
		int noofrows = qry.executeUpdate();
		if (noofrows > 0) {
			System.out.println("deleted successfully...");
		}
		return getQuizList();
	}

	
	public Quiz getQuizID(int qid) {
		Query qry =getSession().createQuery("from Quiz sub where qid=:eno");
		qry.setParameter("eno",qid);
		
		Quiz stulist=(Quiz)qry.uniqueResult();
		System.out.println(stulist);
		return stulist;

}
	
	
	@Override
	public List<Quiz> searchQuizById(int qid) {
		Query query = getSession().createQuery("from Quiz sub where qid=:eno");
		query.setParameter("eno", qid);
		List<Quiz> stulist =query.list();
		System.out.println(stulist);
		return stulist;
	}




	@Override
	public List<Quiz> getSubjectID(int subid) {
		Query qry =getSession().createQuery("from Quiz qz where subject_id=:eno");
        qry.setParameter("eno",subid);
        
        List<Quiz> stulist=qry.list();
        System.out.println(stulist);
        return stulist;
	}


}


