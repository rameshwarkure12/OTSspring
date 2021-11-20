package com.mph.controller;

import java.util.List;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.mph.entity.*;
import com.mph.service.*;

@RestController

@RequestMapping(value = "/student")
@CrossOrigin(origins = "http://localhost:4200", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
		RequestMethod.DELETE }, allowCredentials = "false", allowedHeaders = "*")

public class StudentRestController {

	@Autowired
	StudentService studentService;

	private static final Logger logger = Logger.getLogger("StudentRestController.class");

	@GetMapping("/allstu")
	public ResponseEntity<List<Student>> allStudent() {

		logger.info("getting http request  from angular application to list students");
		System.out.println(logger.getName() + " " + logger.getLevel());

		PropertyConfigurator.configure(StudentRestController.class.getClassLoader().getResource("log4j.properties"));
		System.out.println("Logger config is successfull...");

		List<Student> elist = studentService.getStudentList();
		System.out.println(elist);
		if (elist.isEmpty()) {
			return new ResponseEntity<List<Student>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Student>>(elist, HttpStatus.OK);

	}

	@PostMapping("/createStudent")
	public Student createStudent(@RequestBody Student student) {
		
		studentService.createStudent(student);
		
		return student;
	}

	@PutMapping("/updateStudent")
	public ResponseEntity<?> updateStudent(@RequestBody Student student) {

		logger.info(" http request  from angular application to update student");
		System.out.println(logger.getName()+" "+logger.getLevel());
		
		PropertyConfigurator.configure(StudentRestController.class.getClassLoader().getResource("log4j.properties"));
		System.out.println("Logger config is successfull...");

		studentService.updateStudent(student);
//		System.out.println(uelist);
//		if (uelist.isEmpty()) {
//			return new ResponseEntity<List<Student>>(HttpStatus.NO_CONTENT);
//		}
		return new ResponseEntity("successfully updated..", HttpStatus.OK);

	}

	@DeleteMapping("/deleteStudent/{stid}")
	public ResponseEntity<?> updateStudent(@PathVariable("stid") int eid) {

		logger.info("deleted student http request  from angular application  by id");
		System.out.println(logger.getName()+" "+logger.getLevel());
		
		PropertyConfigurator.configure(StudentRestController.class.getClassLoader().getResource("log4j.properties"));
		System.out.println("Logger config is successfull...");
//		

		List<Student> delist = studentService.deleteStudent(eid);
		System.out.println(delist);
		if (delist.isEmpty()) {
			return new ResponseEntity<List<Student>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Student>>(delist, HttpStatus.OK);
	}

	@GetMapping("/byIdStudent/{stid}")
	public ResponseEntity<?> getByIdEmployee(@PathVariable("stid") int eid) {
		
		logger.info("get student http request  from angular application  by id");
		System.out.println(logger.getName()+" "+logger.getLevel());
		
		PropertyConfigurator.configure(StudentRestController.class.getClassLoader().getResource("log4j.properties"));
		System.out.println("Logger config is successfull...");
		
		
		
		Student delist = studentService.getStudentID(eid);
		System.out.println(delist);

		if (delist == null) {
			return new ResponseEntity<Student>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Student>(delist, HttpStatus.OK);
	}

	/*------------to send student data using api to validate in angular-----------------*/

	@GetMapping("/validateStu/{email}")
	public ResponseEntity<?> getByIdEmployee(@PathVariable("email") String email) {
		
		logger.info("validating student by email");
		System.out.println(logger.getName()+" "+logger.getLevel());
		
		PropertyConfigurator.configure(StudentRestController.class.getClassLoader().getResource("log4j.properties"));
		System.out.println("Logger config is successfull...");
		
		
		
		
		Student delist = studentService.getStudentEmail(email);
		System.out.println(delist);

		if (delist == null) {
			return new ResponseEntity<Student>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Student>(delist, HttpStatus.OK);

	}

}
