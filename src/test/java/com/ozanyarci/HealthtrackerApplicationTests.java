package com.ozanyarci;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import java.sql.Date;
import java.util.Calendar;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.ozanyarci.model.Customer;
import com.ozanyarci.model.User;
import com.ozanyarci.service.ProfileService;
import com.ozanyarci.service.SignUpService;
import com.ozanyarci.service.UserLoginService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest

public class HealthtrackerApplicationTests {

	@Autowired
	UserLoginService userLoginService;

	@Autowired
	SignUpService signUpService;

	@Autowired
	ProfileService profileService;
	
	@Autowired 
	WebApplicationContext webApplicationContext; 

	private MockMvc mockMvc;

	@Test
	public void testUserExists() {
		assertThat(userLoginService, instanceOf(UserLoginService.class));
		assertThat(userLoginService.authenticateEncriptedUserData("a", "cc175b9c0f1b6a831c399e269772661"), is(true));

	}

	@Test
	public void testCreateCustomer() {
		assertThat(signUpService, instanceOf(SignUpService.class));
		assertThat(profileService, instanceOf(ProfileService.class));
		Customer customer = new Customer();
		String userName = UUID.randomUUID().toString();
		Date now = new Date(Calendar.getInstance().getTime().getTime());
		customer.setUserName(userName);
		customer.setBirthDate(now);
		customer.setGender("Male");
		customer.setEmail("ozanyarci@gmail.com");
		customer.setHeight(1.80);
		customer.setWeight(80);
		customer.setName("Ozan");
		signUpService.createCustomer(customer);
		assertNotNull(profileService.getCustomer(userName));
	}

	@Test
	public void testInsertUserSuccess() {
		User user = new User();
		String userName = UUID.randomUUID().toString();
		user.setUserName(userName);
		user.setPassword("1234");
		assertThat(signUpService.insertUser(user), is(true));
	}

	@Test
	public void testInsertUserFalse() {
		User user = new User();
		user.setUserName("a");
		user.setPassword("a");
		assertThat(signUpService.insertUser(user), is(false));
	}

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
	}

	@Test
	public void testControllerMethodToLogin() throws Exception{		
		mockMvc.perform(get("/"))
			.andExpect(status().isOk())
			.andExpect(view().name("login/login"))
			.andExpect(forwardedUrl("/views/login/login.jsp"))
			.andExpect(model().attributeExists("user"));
	}
	
	@Test
	public void testControllerMethodGoToSignUp() throws Exception{		
		mockMvc.perform(get("/signup"))
			.andExpect(status().isOk())
			.andExpect(view().name("signup/signup"))
			.andExpect(forwardedUrl("/views/signup/signup.jsp"))
			.andExpect(model().attributeExists("customer"))
			.andExpect(model().attributeExists("defaultDate"));
	}
	

}
