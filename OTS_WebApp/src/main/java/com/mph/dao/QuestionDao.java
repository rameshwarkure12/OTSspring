package com.mph.dao;

import java.util.List;

import com.mph.entity.Question;
import com.mph.entity.Quiz;

public interface QuestionDao {
	
	  public List<Question> getQuestionList();
	    public Question getQuestionById(int qid);
	    public List<Question> deleteQuestionById(int qid);
	    public void addQuestion(Question question);
	    public void updateQuestion(Question question);
	    public List<Question> getQuizID(int qid);
	    
	 

}
