package com.mph.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mph.entity.Quiz;



public interface QuizService {
	
	public List<Quiz> getQuizList();
    public Quiz getQuizID(int qid);
    public List<Quiz> deleteQuizById(int qid);
    public void createQuiz(Quiz quiz);
    public void updateQuiz(Quiz quiz);
	public List<Quiz> getSubID(int subid);

}
