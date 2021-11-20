package com.mph.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mph.dao.QuizDao;
import com.mph.dao.SubjectDao;
import com.mph.entity.Quiz;

@Service
@Transactional
public class QuizServiceImpl implements QuizService{
	
	@Autowired
	QuizDao quizDao;
	
	

	@Override
	public List<Quiz> getQuizList() {
		
		return quizDao.getQuizList();
	}
	
	

	@Override
	public Quiz getQuizID(int qid) {
		
		return quizDao.getQuizID(qid);
	}
	
	

	@Override
	public List<Quiz> deleteQuizById(int qid) {
		
		return quizDao.deleteQuizById(qid);
	}
	
	

	@Override
	public void createQuiz(Quiz quiz) {
		
		quizDao.createQuiz(quiz);
	}
	
	

	@Override
	public void updateQuiz(Quiz quiz) {
		
		quizDao.updateQuiz(quiz);
	}



	@Override
	public List<Quiz> getSubID(int subid) {
		
		return quizDao.getSubjectID(subid);
	}


}
