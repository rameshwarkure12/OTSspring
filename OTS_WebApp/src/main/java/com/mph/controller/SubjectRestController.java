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
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.mph.entity.Subject;
import com.mph.service.SubjectService;

@RestController
@EnableWebMvc
@RequestMapping(value = "/subject")
@CrossOrigin(origins = "*" ,methods = {RequestMethod.GET,RequestMethod.POST,
        RequestMethod.PUT,RequestMethod.DELETE },allowCredentials = "false",allowedHeaders = "*")
public class SubjectRestController {
   
	@Autowired
    SubjectService subjectService;
	
	private static final Logger logger = Logger.getLogger("SubjectRestController.class");
	
	 @GetMapping("/allsub")
	    public ResponseEntity<List<Subject>> allSubject() {
		 
		 logger.info("getting http request  from angular application to list subjects");
			System.out.println(logger.getName() + " " + logger.getLevel());

			PropertyConfigurator.configure(SubjectRestController.class.getClassLoader().getResource("log4j.properties"));
			System.out.println("Logger config is successfull...");
		 
		 
		 
	        List<Subject> elist = subjectService.getSubjectList();
	        System.out.println(elist);
	        if (elist.isEmpty()) {
	            return new ResponseEntity<List<Subject>>(HttpStatus.NO_CONTENT);
	        }
	        return new ResponseEntity<List<Subject>>(elist, HttpStatus.OK);
	 }
	 
	 @PostMapping("/createSubject")
	    public Subject createStudent(@RequestBody Subject subject) {
		 
		 
		 logger.info("getting http request  from angular application to create subjects");
			System.out.println(logger.getName() + " " + logger.getLevel());

			PropertyConfigurator.configure(SubjectRestController.class.getClassLoader().getResource("log4j.properties"));
			System.out.println("Logger config is successfull...");
		 
		 
	        
	        subjectService.createSubject(subject);
	        
	        
	        return subject;
	    }
	 
	 
	 @PutMapping("/updateSubject")
	    public ResponseEntity<?> updateSubject(@RequestBody Subject subject) {
		 
		 logger.info("getting http request  from angular application to update Subjects");
			System.out.println(logger.getName() + " " + logger.getLevel());

			PropertyConfigurator.configure(SubjectRestController.class.getClassLoader().getResource("log4j.properties"));
			System.out.println("Logger config is successfull...");
		 
		 
		 
		  subjectService.updateSubject(subject);
	        return new ResponseEntity("successfully updated..", HttpStatus.OK);
	    }
	 
	 
	 
	 @DeleteMapping("/deleteSubject/{subid}")
	    public ResponseEntity<?> updateSubject(@PathVariable("subid") int eid) {
		 
		 logger.info("getting http request  from angular application to delete Subjects by id");
			System.out.println(logger.getName() + " " + logger.getLevel());

			PropertyConfigurator.configure(SubjectRestController.class.getClassLoader().getResource("log4j.properties"));
			System.out.println("Logger config is successfull...");
		 
	    
	        
	        List<Subject> delist = subjectService.deleteSubject(eid);
	        System.out.println(delist);
	        if (delist.isEmpty()) {
	            return new ResponseEntity<List<Subject>>(HttpStatus.NO_CONTENT);
	        }
	        return new ResponseEntity<List<Subject>>(delist, HttpStatus.OK);
	    }
	 
	 @GetMapping("/byIdSubject/{stid}")
	    public ResponseEntity<?> getByIdSubject(@PathVariable("stid") int eid) {
		 
		 logger.info("getting http request  from angular application to by Subjects id");
			System.out.println(logger.getName() + " " + logger.getLevel());

			PropertyConfigurator.configure(SubjectRestController.class.getClassLoader().getResource("log4j.properties"));
			System.out.println("Logger config is successfull...");
			
			
	        Subject delist = subjectService.getSubjectID(eid);
	        System.out.println(delist);
	        
	        if (delist==null) {
	            return new ResponseEntity<Subject>(HttpStatus.NO_CONTENT);
	        }
	        return new ResponseEntity<Subject>(delist, HttpStatus.OK);
	    }
	 
	 
	 
	 
	 
	 
	 
	

}
