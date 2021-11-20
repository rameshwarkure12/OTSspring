package com.mph.entity;

import javax.persistence.*;

@Entity
@Table(name="Result")

public class Result {
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name="res_generator", sequenceName = "hibernate_sequence")
    private int result_id;
    
    
    @OneToOne
    @JoinColumn(name = "st_id", referencedColumnName = "ST_ID")
    private Student student;
    
    
    @OneToOne
    @JoinColumn(name = "subject_id", referencedColumnName = "SUBJECT_ID")
    private Subject subject;
    
    @Column
    private String scored_marks;

	public Result() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Result(int result_id, Student student, Subject subject, String scored_marks) {
		super();
		this.result_id = result_id;
		this.student = student;
		this.subject = subject;
		this.scored_marks = scored_marks;
	}

	public int getResult_id() {
		return result_id;
	}

	public void setResult_id(int result_id) {
		this.result_id = result_id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public String getScored_marks() {
		return scored_marks;
	}

	public void setScored_marks(String scored_marks) {
		this.scored_marks = scored_marks;
	}

	@Override
	public String toString() {
		return "Result [result_id=" + result_id + ", student=" + student + ", subject=" + subject + ", scored_marks="
				+ scored_marks + "]";
	}
    
    
	

}
