package com.mph.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mph.dao.QuestionDao;
import com.mph.entity.Question;

@Lazy
@Service
@Transactional
public class QuestionServiceImpl implements QuestionService{

	@Autowired
	QuestionDao questionDao;
	
	
	@Override
    public List<Question> getQuestionList() {
        
        return questionDao.getQuestionList();
    }
    @Override
    public Question getQuestionById(int qid) {
        
        return questionDao.getQuestionById(qid);
    }
    @Override
    public List<Question> deleteQuestionById(int qid) {
        
        return questionDao.deleteQuestionById(qid);
    }
    @Override
    public void addQuestion(Question question) {
        
        questionDao.addQuestion(question);
    }
    
    @Override
    public void updateQuestion(Question question) {
        
        questionDao.updateQuestion(question);
    }
	@Override
	public List<Question> getQuizID(int qid) {
		// TODO Auto-generated method stub
		 return questionDao.getQuizID(qid);
	}

}
