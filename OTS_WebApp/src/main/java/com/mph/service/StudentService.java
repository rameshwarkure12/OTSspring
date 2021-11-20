package com.mph.service;

import java.util.Comparator;
import java.util.List;

import com.mph.entity.Student;

public interface StudentService {

	public List<Student> getStudentList();
	public Student getStudent(Student student);
	public void createStudent(Student student);
	public void updateStudent(Student student);
	public List<Student> deleteStudent(int stid);
	public Student getStudentID(int stid);
	public List<Student> searchStudentById(int stid);
	public Student getStudentEmail(String email);
	
}
