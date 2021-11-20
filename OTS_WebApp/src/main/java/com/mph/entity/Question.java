package com.mph.entity;

import javax.persistence.*;

@Entity
@Table(name="Question")
public class Question {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name="sid_generator", sequenceName = "hibernate_sequence")
    private int question_id;
    private String qdescription;
    private String op1;
    private String op2;
    private String op3;
    private String op4;
    private String answer;
    
   
    
    @ManyToOne //many question one subject
    @JoinColumn(name = "qid", referencedColumnName = "qid")
    private Quiz quiz;

	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Question(int question_id, String qdescription, String op1, String op2, String op3, String op4, String answer,
			 Quiz quiz) {
		super();
		this.question_id = question_id;
		this.qdescription = qdescription;
		this.op1 = op1;
		this.op2 = op2;
		this.op3 = op3;
		this.op4 = op4;
		this.answer = answer;
		
		this.quiz = quiz;
	}

	public int getQuestion_id() {
		return question_id;
	}

	public void setQuestion_id(int question_id) {
		this.question_id = question_id;
	}

	

	public String getQdescription() {
		return qdescription;
	}

	public void setQdescription(String qdescription) {
		this.qdescription = qdescription;
	}

	public String getOp1() {
		return op1;
	}

	public void setOp1(String op1) {
		this.op1 = op1;
	}

	public String getOp2() {
		return op2;
	}

	public void setOp2(String op2) {
		this.op2 = op2;
	}

	public String getOp3() {
		return op3;
	}

	public void setOp3(String op3) {
		this.op3 = op3;
	}

	public String getOp4() {
		return op4;
	}

	public void setOp4(String op4) {
		this.op4 = op4;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	

	public Quiz getQuiz() {
		return quiz;
	}

	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}

	@Override
	public String toString() {
		return "Question [question_id=" + question_id + ", qdescription=" + qdescription + ", op1=" + op1 + ", op2=" + op2
				+ ", op3=" + op3 + ", op4=" + op4 + ", answer=" + answer + ", quiz=" + quiz + "]";
	}
	
	

	

	
    
    

}
