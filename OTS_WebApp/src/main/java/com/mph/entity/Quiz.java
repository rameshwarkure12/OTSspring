package com.mph.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="Quiz")
public class Quiz {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name="sid_generator", sequenceName = "hibernate_sequence")
	private int qid;
	
	@Column
	private String title;
	
	@Column
	private int maxMarks;
	
	@Column
	private int numberOfQuestions; 
	
	   @ManyToOne //many quiz one subject
	    @JoinColumn(name = "subject_id", referencedColumnName = "SUBJECT_ID")
	    private Subject subject;
	   
	   @Column
	    @JsonFormat(pattern = "yyyy-MM-dd")
	    @Temporal(TemporalType.DATE)
	    private Date test_date;

	public Quiz() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Quiz(int qid, String title, int maxMarks, int numberOfQuestions, Subject subject, Date test_date) {
		super();
		this.qid = qid;
		this.title = title;
		this.maxMarks = maxMarks;
		this.numberOfQuestions = numberOfQuestions;
		this.subject = subject;
		this.test_date = test_date;
	}

	

	public int getQid() {
		return qid;
	}

	public void setQid(int qid) {
		this.qid = qid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getMaxMarks() {
		return maxMarks;
	}

	public void setMaxMarks(int maxMarks) {
		this.maxMarks = maxMarks;
	}

	public int getNumberOfQuestions() {
		return numberOfQuestions;
	}

	public void setNumberOfQuestions(int numberOfQuestions) {
		this.numberOfQuestions = numberOfQuestions;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public Date getTest_date() {
		return test_date;
	}

	public void setTest_date(Date test_date) {
		this.test_date = test_date;
	}

	@Override
	public String toString() {
		return "Quiz [qid=" + qid + ", title=" + title + ", maxMarks=" + maxMarks + ", numberOfQuestions="
				+ numberOfQuestions + ", subject=" + subject + ", test_date=" + test_date + "]";
	}
	   
	   
	
	
	
	
	

}
