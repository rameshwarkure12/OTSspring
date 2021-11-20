package com.mph.dao;

import java.util.List;

import com.mph.entity.Quiz;

public interface QuizDao {
	
	public List<Quiz> getQuizList();
    public Quiz getQuizID(int qid);
    public List<Quiz> deleteQuizById(int qid);
    public void createQuiz(Quiz quiz);
    public void updateQuiz(Quiz quiz);
    public List<Quiz> searchQuizById(int qid);
	public List<Quiz> getSubjectID(int subid);

}
