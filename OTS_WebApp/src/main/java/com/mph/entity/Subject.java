package com.mph.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="Subject")
public class Subject {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name="sid_generator", sequenceName = "hibernate_sequence")
	private int subject_id;
	
	@Column
	private String subject_name;
	
    @OneToMany(mappedBy = "subject", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Quiz> quiz;
    
    
    
    public Subject() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Subject(int subject_id, String subject_name, List<Quiz> quiz) {
		super();
		this.subject_id = subject_id;
		this.subject_name = subject_name;
		this.quiz = quiz;
	}



	public int getSubject_id() {
		return subject_id;
	}



	public void setSubject_id(int subject_id) {
		this.subject_id = subject_id;
	}



	public String getSubject_name() {
		return subject_name;
	}



	public void setSubject_name(String subject_name) {
		this.subject_name = subject_name;
	}



	@Override
	public String toString() {
		return "Subject [subject_id=" + subject_id + ", subject_name=" + subject_name + "]";
	}

	

	

	
    
	
	
	
}
