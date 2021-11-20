package com.mph.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import com.mph.entity.Name;
import com.mph.entity.Student;


import com.mph.service.StudentService;

@Controller
public class StudentController {

	
	@Autowired
	StudentService studentService;
	Student student;
	
	
	
	
	
	@RequestMapping(value="registerpage",method=RequestMethod.GET) //view
	public ModelAndView register()          //Handler method
	{
		return new ModelAndView("register");     //page name
	}
	
	@RequestMapping(value="loginpage",method=RequestMethod.GET) //view
	public ModelAndView login()          //Handler method
	{
		return new ModelAndView("login");     //page name
	}
	
	@RequestMapping(value = "register",method = RequestMethod.POST)	
	public ModelAndView signup(
			@RequestParam("txtfename") String fname,
			@RequestParam("txtlename") String lname,
			@RequestParam("txtemail") String email,
			@RequestParam("txtpassword") String password,
			@RequestParam("txtgender") String gender,
			@RequestParam("txtcontact") String contact,
		
			@RequestParam("txthouseno") int hno ,
			@RequestParam("txtstreet") String street,
			@RequestParam("txtcity") String city,
			@RequestParam("txtstate") String state,
			@RequestParam("txtpincode") int pincode) {
		System.out.println( fname+" "+lname+ " " + email + " " + password + " " + gender+" "+contact+" "+hno+" "+street+" "+city+" "+state+" "+pincode);
		
		student=new Student();
		student.setSt_firstName(fname);
		student.setSt_lastName(lname);
		student.setSt_email(email);
		student.setSt_password(password);
		student.setSt_gender(gender);
		student.setSt_contact(contact);
		
		
	studentService.createStudent(student);
		
	return new ModelAndView("login");   
	}
	
	
	public ModelAndView allStudent()     //will provide list of employee to "signin" from employee service
	{
		List<Student> emplist=studentService.getStudentList();
		ModelAndView mv=new ModelAndView("home");
		mv.addObject("allemp", emplist);  //will transfer list of employees(emplist) to home.jsp(allemp)
		return mv;
		
	}
	
	@RequestMapping(value="signin",method=RequestMethod.GET)
	public ModelAndView signin(@RequestParam("txtemail") String st_email,@RequestParam("txtpassword")String st_password)
	{
		student=new Student();
		student.setSt_email(st_email);
		student.setSt_password(st_password);
		
		Student stu=studentService.getStudent(student);
		if(stu==null)
		{
			ModelAndView mv=new ModelAndView("login");
			mv.addObject("msg", "Requested data not found!!! ,Try again...");
			return mv;
			
		}
		else
		{
			return allStudent();  //page name
		}
	}
		
		@RequestMapping(value="/delete",method=RequestMethod.GET)
		public ModelAndView delete(Student stu)
		{
			List<Student>emplist =studentService.deleteStudent(stu.getSt_id());
			ModelAndView mv = new ModelAndView("home");
			mv.addObject("allemp", emplist);
			return mv;
		}
		
		

		@RequestMapping(value = "/edit", method = RequestMethod.GET) // view name
		public ModelAndView edit(Student stu) {
			return new ModelAndView("edit");
		}
		
		
		
		
		@RequestMapping(value = "/update", method = RequestMethod.POST) // view name
		public ModelAndView update(@ModelAttribute Student stu) {
		
					studentService.updateStudent(stu);		
			ModelAndView mv = new ModelAndView("home");
			//mv.addObject("allemp", emplist);
			return mv;
			
		
		}
		
		@RequestMapping(value="/search",method=RequestMethod.GET)
		public ModelAndView search(@RequestParam("txteid") String eid)
		{
			int eno = Integer.parseInt(eid);
			List<Student> emplist = studentService.searchStudentById(eno);
			boolean emp = emplist.isEmpty();
			if (emp) {

				ModelAndView mv = new ModelAndView("home");
				return mv.addObject("NOTIFICATION", "Employee NOT Found :( ");
			} else {

				ModelAndView mv = new ModelAndView("home");
				return mv.addObject("allemp", emplist);
			}
		}
		
		
		
	}
	
	
	

