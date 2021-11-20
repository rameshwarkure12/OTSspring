package com.mph.entity;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.web.multipart.MultipartFile;

import org.hibernate.annotations.Proxy;

import com.fasterxml.jackson.annotation.JsonFormat;

import com.mph.entity.Name;


@Entity
@Table(name = "OTS_stu")

public class Student {
	
	
	
		@Id
		@GeneratedValue(strategy = GenerationType.SEQUENCE)
		@SequenceGenerator(name="sid_generator", sequenceName = "hibernate_sequence")
		private int st_id;

		@Column
		
		private String st_firstName;
		@Column
		private String st_lastName;
		@Column(unique=true)
		private String st_email;
		@Column
		private String st_password;
		@Column
		private String st_gender;
		@Column(unique=true)
		private String st_contact;
		@JsonFormat(pattern = "yyyy-MM-dd")
		@Column
		@Temporal(TemporalType.DATE)
		private Date dob;
//		@Column
//		MultipartFile photo;
//		byte[] photoBytes = photo.getBytes();

//		@JsonFormat(pattern = "HH:MM:SS")
//		private Timestamp timeOfBirth;

		public Student() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Student(int st_id, String st_firstName,String st_lastName, String st_email, String st_password, String st_gender,
				String st_contact, Date dob) {
			super();
			this.st_id = st_id;
			this.st_firstName = st_firstName;
			this.st_lastName = st_lastName;
			this.st_email = st_email;
			this.st_password = st_password;
			this.st_gender = st_gender;
			this.st_contact = st_contact;
			this.dob = dob;
		//	this.timeOfBirth = timeOfBirth;
		}

		public int getSt_id() {
			return st_id;
		}

		public void setSt_id(int st_id) {
			this.st_id = st_id;
		}

		public String getSt_firstName() {
			return st_firstName;
		}

		public void setSt_firstName(String st_firstName ) {
			this.st_firstName = st_firstName;
		}
		public String getSt_lastName() {
			return st_lastName;
		}

		public void setSt_lastName(String st_lastName ) {
			this.st_lastName = st_lastName;
		}

		public String getSt_email() {
			return st_email;
		}

		public void setSt_email(String st_email) {
			this.st_email = st_email;
		}

		public String getSt_password() {
			return st_password;
		}

		public void setSt_password(String st_password) {
			this.st_password = st_password;
		}

		public String getSt_gender() {
			return st_gender;
		}

		public void setSt_gender(String st_gender) {
			this.st_gender = st_gender;
		}

		public String getSt_contact() {
			return st_contact;
		}

		public void setSt_contact(String st_contact) {
			this.st_contact = st_contact;
		}

		public Date getDob() {
			return dob;
		}

		public void setDob(Date dob) {
			this.dob = dob;
		}

		@Override
		public String toString() {
			return "Student [st_id=" + st_id + ", st_firstName=" + st_firstName + ", st_lastName=" + st_lastName
					+ ", st_email=" + st_email + ", st_password=" + st_password + ", st_gender=" + st_gender
					+ ", st_contact=" + st_contact + ", dob=" + dob + "]";
		}

//		public Timestamp getTimeOfBirth() {
//			return timeOfBirth;
//		}
//
//		public void setTimeOfBirth(Timestamp timeOfBirth) {
//			this.timeOfBirth = timeOfBirth;
//		}

		
		
		
		


		


		
	
}
