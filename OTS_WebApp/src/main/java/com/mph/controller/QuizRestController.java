package com.mph.controller;

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

import com.mph.entity.Quiz;
import com.mph.service.QuizService;

@RestController
@RequestMapping(value = "/quiz")
@CrossOrigin(origins = "*" ,methods = {RequestMethod.GET,RequestMethod.POST,
		RequestMethod.PUT,RequestMethod.DELETE },allowCredentials = "false",allowedHeaders = "*")
public class QuizRestController {
	
	@Autowired
	QuizService quizService;
	
	private static final Logger logger = Logger.getLogger("QuizRestController.class");
	
	@GetMapping("/allquiz")
	public ResponseEntity<List<Quiz>> allQuiz() {
		
		logger.info("getting http request  from angular application to list Quizes");
		System.out.println(logger.getName() + " " + logger.getLevel());

		PropertyConfigurator.configure(QuizRestController.class.getClassLoader().getResource("log4j.properties"));
		System.out.println("Logger config is successfull...");
		
		
		
		List<Quiz> elist = quizService.getQuizList();
		System.out.println(elist);
		if (elist.isEmpty()) {
			return new ResponseEntity<List<Quiz>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Quiz>>(elist, HttpStatus.OK);

	}
	
	@PostMapping("/createQuiz")
	public Quiz createQuiz (@RequestBody Quiz quiz ) {
		
		logger.info("getting http request  from angular application to create Quizes");
		System.out.println(logger.getName() + " " + logger.getLevel());

		PropertyConfigurator.configure(QuizRestController.class.getClassLoader().getResource("log4j.properties"));
		System.out.println("Logger config is successfull...");
		
		
		quizService.createQuiz(quiz);
		System.out.println(quiz );
		
		return quiz ;
	}
	
	@PutMapping("/updateQuiz")
	public ResponseEntity<?> updateQuiz(@RequestBody Quiz quiz) {	
		
		logger.info("getting http request  from angular application to update Quizes");
		System.out.println(logger.getName() + " " + logger.getLevel());

		PropertyConfigurator.configure(QuizRestController.class.getClassLoader().getResource("log4j.properties"));
		System.out.println("Logger config is successfull...");
		
		
		
	quizService.updateQuiz(quiz);
		return new ResponseEntity("successfully updated..", HttpStatus.OK);

	}
	
	
	@DeleteMapping("/deleteQuiz/{qid}")
	public ResponseEntity<?> updateQuiz(@PathVariable("qid") int eid) {
		
		logger.info("getting http request  from angular application to delete Quizes by id");
		System.out.println(logger.getName() + " " + logger.getLevel());

		PropertyConfigurator.configure(QuizRestController.class.getClassLoader().getResource("log4j.properties"));
		System.out.println("Logger config is successfull...");
		
	
		
		List<Quiz> delist = quizService.deleteQuizById(eid);
		System.out.println(delist);
		if (delist.isEmpty()) {
			return new ResponseEntity<List<Quiz>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Quiz>>(delist, HttpStatus.OK);
	}
	
	@GetMapping("/byIdQuiz/{qid}")
	public ResponseEntity<?> getByIdEmployee(@PathVariable("qid") int eid) {
		
		logger.info("getting http request  from angular application to by Quizes by id");
		System.out.println(logger.getName() + " " + logger.getLevel());

		PropertyConfigurator.configure(QuizRestController.class.getClassLoader().getResource("log4j.properties"));
		System.out.println("Logger config is successfull...");
		
		
		
		Quiz delist = quizService.getQuizID(eid);
		System.out.println(delist);
		

		if (delist==null) {
			return new ResponseEntity<Quiz>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Quiz>(delist, HttpStatus.OK);
	}

	@GetMapping("/allquiz/{subid}")
	public ResponseEntity<?> getByIdSubject(@PathVariable("subid") int subid) {
		
		logger.info("getting http request  from angular application to list Quizes by subjectid");
		System.out.println(logger.getName() + " " + logger.getLevel());

		PropertyConfigurator.configure(QuizRestController.class.getClassLoader().getResource("log4j.properties"));
		System.out.println("Logger config is successfull...");
		
		
		List<Quiz> delist = quizService.getSubID(subid);
		System.out.println(delist);
		

		if (delist==null) {
			return new ResponseEntity<List<Quiz>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Quiz>>(delist, HttpStatus.OK);
	}
	




}
