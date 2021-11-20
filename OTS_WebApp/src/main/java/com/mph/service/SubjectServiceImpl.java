package com.mph.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mph.dao.SubjectDao;
import com.mph.entity.Subject;

@Lazy
@Service
@Transactional
public class SubjectServiceImpl implements SubjectService{

	@Autowired
	SubjectDao subjectDao; 
	
	
public List<Subject> getSubjectList() {
        
        return subjectDao.getSubjectList();
    }
    public Subject getSubject(Subject subject) {
        return subjectDao.getSubject(subject);
    }
    public void createSubject(Subject subject) {
        subjectDao.createSubject(subject);
        
    }
    public void updateSubject(Subject subject) {
        subjectDao.updateSubject(subject);
    }
    public List<Subject> deleteSubject(int subid) {
        return subjectDao.deleteSubject(subid);
    }
    public Subject getSubjectID(int subid) {
        return subjectDao.getSubjectID(subid);
    }
    public List<Subject> searchSubjectById(int subid) {
        return subjectDao.searchSubjectById(subid);
    }
    
	
	

}
