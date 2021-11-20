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

import com.mph.entity.Question;
import com.mph.entity.Quiz;
import com.mph.service.QuestionService;

import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping(value = "/question")
@CrossOrigin(origins = "http://localhost:4200" ,methods = {RequestMethod.GET,RequestMethod.POST,
        RequestMethod.PUT,RequestMethod.DELETE },allowCredentials = "false",allowedHeaders = "*")
public class QuestionRestController {
	
	@Autowired
    QuestionService questionService;
	private static final Logger logger = Logger.getLogger("QuestionRestController.class");
    
    @GetMapping("/allquestion")
    public ResponseEntity<List<Question>> allQuestion() {
    	
    	logger.info("getting http request  from angular application to list questions");
		System.out.println(logger.getName() + " " + logger.getLevel());

		PropertyConfigurator.configure(QuestionRestController.class.getClassLoader().getResource("log4j.properties"));
		System.out.println("Logger config is successfull...");
    	
    	
    
        List<Question> elist = questionService.getQuestionList();
        System.out.println(elist);
        if (elist.isEmpty()) {
            return new ResponseEntity<List<Question>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Question>>(elist, HttpStatus.OK);
    }
    
    @PostMapping("/createQuestion")
    public Question createQuestion(@RequestBody Question question) {
    	
    	logger.info("getting http request  from angular application to create questions");
		System.out.println(logger.getName() + " " + logger.getLevel());

		PropertyConfigurator.configure(QuestionRestController.class.getClassLoader().getResource("log4j.properties"));
		System.out.println("Logger config is successfull...");
    	
    	
        
        questionService.addQuestion(question);
        
        
        return question;
    }
    
    
    @PutMapping("/updateQuestion")
    public ResponseEntity<?> updateQuestion(@RequestBody Question question) {
        
    	logger.info("getting http request  from angular application to update questions");
		System.out.println(logger.getName() + " " + logger.getLevel());

		PropertyConfigurator.configure(QuestionRestController.class.getClassLoader().getResource("log4j.properties"));
		System.out.println("Logger config is successfull...");
    	
    	
    	
    
        questionService.updateQuestion(question);
        
        return new ResponseEntity("successfully updated..", HttpStatus.OK);
    }
    
    @DeleteMapping("/deleteQuestion/{qid}")
    public ResponseEntity<?> updateQuestion(@PathVariable("qid") int eid) {
    	
    	logger.info("getting http request  from angular application to delete questions by id");
		System.out.println(logger.getName() + " " + logger.getLevel());

		PropertyConfigurator.configure(QuestionRestController.class.getClassLoader().getResource("log4j.properties"));
		System.out.println("Logger config is successfull...");
    	
    
        
        List<Question> delist = questionService.deleteQuestionById(eid);
        System.out.println(delist);
        if (delist.isEmpty()) {
            return new ResponseEntity<List<Question>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Question>>(delist, HttpStatus.OK);
    }
    
    @GetMapping("/byIdQuestion/{qid}")
    public ResponseEntity<?> getByIdQuestion(@PathVariable("qid") int eid) {
    	
    	
    	logger.info("getting http request  from angular application to get questions by id");
		System.out.println(logger.getName() + " " + logger.getLevel());

		PropertyConfigurator.configure(QuestionRestController.class.getClassLoader().getResource("log4j.properties"));
		System.out.println("Logger config is successfull...");
    	
    	
    	
    	
    	
        Question delist = questionService.getQuestionById(eid);
        System.out.println(delist);
        
        if (delist==null) {
            return new ResponseEntity<Question>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Question>(delist, HttpStatus.OK);
    }
	
    
    
    @GetMapping("/allquestion/{quid}")
	public ResponseEntity<?> getByIdQuiz(@PathVariable("quid") int subid) {
    	
    	logger.info("getting http request  from angular application to list questions by id");
		System.out.println(logger.getName() + " " + logger.getLevel());

		PropertyConfigurator.configure(QuestionRestController.class.getClassLoader().getResource("log4j.properties"));
		System.out.println("Logger config is successfull...");
    	
    	
    	
    	
		List<Question> delist = questionService.getQuizID(subid);
		System.out.println(delist);
		

		if (delist==null) {
			return new ResponseEntity<List<Question>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Question>>(delist, HttpStatus.OK);
	}
    
    
    

}
