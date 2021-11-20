package com.mph.testcase;

import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.mph.controller.AdminRestController;
import com.mph.entity.Admin;
import com.mph.service.AdminService;




@WebMvcTest(value=AdminRestController.class)
@ContextConfiguration(classes= {AdminRestController.class})
@AutoConfigureMockMvc
public class SubjectRestControllerTest {

	private MockMvc mockMvc;
    @InjectMocks
    AdminRestController adminRestController;
    
    @Mock
    AdminService adminService;
    
    @Before
    public void setUp(){
    	MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(adminRestController).build();
    }
    
  
    

@Test
 public void testgetOrderById() throws Exception{
	
	  
	Admin o = new Admin(1,"name","a@a","pwd");
	Mockito.when(adminService.getAdminID(1)).thenReturn(o);
	mockMvc.perform(MockMvcRequestBuilders.get("/admin/byIdAdmin/1")
	        .accept(MediaType.APPLICATION_JSON))
	                .andExpect(MockMvcResultMatchers.status().isOk())
	                .andExpect(MockMvcResultMatchers.jsonPath("$.admin_id", Matchers.is(1)))
	                .andExpect(MockMvcResultMatchers.jsonPath("$.admin_name",Matchers.is("name")))
	                .andExpect(MockMvcResultMatchers.jsonPath("$.admin_email",Matchers.is("a@a")))
	                .andExpect(MockMvcResultMatchers.jsonPath("$.admin_password",Matchers.is("pwd")));

	        Mockito.verify(adminService).getAdminID(1);
	
}
	
	
}
