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

import com.mph.entity.Admin;
import com.mph.entity.Student;
import com.mph.service.AdminService;
import com.mph.service.StudentService;

@RestController

@RequestMapping(value = "/admin")
@CrossOrigin(origins = "*" ,methods = {RequestMethod.GET,RequestMethod.POST,
		RequestMethod.PUT,RequestMethod.DELETE },allowCredentials = "false",allowedHeaders = "*")


public class AdminRestController {
	

	@Autowired
	AdminService adminService;
	
	private static final Logger logger=Logger.getLogger("AdminRestController.class"); 

	@GetMapping("/alladmin")
	public ResponseEntity<List<Admin>> allAdmin() {
		
		logger.info("getting http request  from angular application to list admin");
		System.out.println(logger.getName()+" "+logger.getLevel());
		
		PropertyConfigurator.configure(StudentRestController.class.getClassLoader().getResource("log4j.properties"));
		System.out.println("Logger config is successfull...");
		
		List<Admin> elist = adminService.getAdminList();
		System.out.println(elist);
		if (elist.isEmpty()) {
			return new ResponseEntity<List<Admin>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Admin>>(elist, HttpStatus.OK);

	}
	
	
	@PostMapping("/createAdmin")
	public Admin createAdmin(@RequestBody Admin admin) {
		
		adminService.createAdmin(admin);
		return admin;
	}
	
	@PutMapping("/updateAdmin")
	public ResponseEntity<?> updateAdmin(@RequestBody Admin admin) {
		
		
		logger.info("updating admin http request from angular application ");
		System.out.println(logger.getName()+" "+logger.getLevel());
		
		PropertyConfigurator.configure(AdminRestController.class.getClassLoader().getResource("log4j.properties"));
		System.out.println("Logger config is successfull...");
		
		adminService.updateAdmin(admin);
//		System.out.println(uelist);
//		if (uelist.isEmpty()) {
//			return new ResponseEntity<List<Student>>(HttpStatus.NO_CONTENT);
//		}
		return new ResponseEntity("successfully updated..", HttpStatus.OK);

	}

	@DeleteMapping("/deleteAdmin/{adid}")
	public ResponseEntity<?> updateAdmin(@PathVariable("adid") int eid) {
		
		logger.info("deleted Admin http request  from angular application by ID");
		System.out.println(logger.getName()+" "+logger.getLevel());
		
		PropertyConfigurator.configure(AdminRestController.class.getClassLoader().getResource("log4j.properties"));
		System.out.println("Logger config is successfull...");
//		
		
		List<Admin> delist = adminService.deleteAdmin(eid);
		System.out.println(delist);
		if (delist.isEmpty()) {
			return new ResponseEntity<List<Admin>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Admin>>(delist, HttpStatus.OK);
	}
	
	@GetMapping("/byIdAdmin/{adid}")
	public ResponseEntity<?> getByIdEmployee(@PathVariable("adid") int eid) {
		
		logger.info("by ID Admin http request from angular application by ID");
		System.out.println(logger.getName()+" "+logger.getLevel());
		
		PropertyConfigurator.configure(AdminRestController.class.getClassLoader().getResource("log4j.properties"));
		System.out.println("Logger config is successfull...");
		
		
		
		Admin delist = adminService.getAdminID(eid);
		System.out.println(delist);
		

		if (delist==null) {
			return new ResponseEntity<Admin>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Admin>(delist, HttpStatus.OK);
	}
}