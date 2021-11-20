package com.mph.service;

import java.util.List;

import com.mph.entity.Name;
import com.mph.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.mph.dao.StudentDao;

@Service
@Transactional
public class StudentServiceImpl implements StudentService{

	
	@Autowired
	StudentDao studentDao;
	
	@Override
	public List<Student> getStudentList() {
		
		return studentDao.getStudentList();
	}

	@Override
	public Student getStudent(Student student) {

		return studentDao.getStudent(student);
	}

	@Override
	public void createStudent(Student student) {

		studentDao.createStudent(student);
		
	}

	@Override
	public void updateStudent(Student student) {

		studentDao.updateStudent(student);
	}

	@Override
	public List<Student> deleteStudent(int stid) {

		return studentDao.deleteStudent(stid);
	}

	@Override
	public Student getStudentID(int stid) {

		return studentDao.getStudentID(stid);
	}

	@Override
	public List<Student> searchStudentById(int stid) {

		return studentDao.searchStudentById(stid);
	}

	@Override
	public Student getStudentEmail(String email) {
		// TODO Auto-generated method stub
		return studentDao.getStudentEmail(email);
	}

	
	}


