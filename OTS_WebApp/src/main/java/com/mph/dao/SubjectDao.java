package com.mph.dao;

import java.util.List;

import com.mph.entity.Subject;

public interface SubjectDao {
	
	 public List<Subject> getSubjectList();
	    public Subject getSubject(Subject subject);
	    public void createSubject(Subject subject);
	    public void updateSubject(Subject subject);
	    public List<Subject> deleteSubject(int subid);
	    public Subject getSubjectID(int subid);
	    public List<Subject> searchSubjectById(int subid);

}
