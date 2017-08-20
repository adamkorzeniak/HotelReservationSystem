//package com.adamkorzeniak.HRS.security.service;
//
//import static org.junit.Assert.*;
//import static org.mockito.Matchers.eq;
//import static org.mockito.Mockito.when;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.runners.MockitoJUnitRunner;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//import com.adamkorzeniak.HRS.security.Role;
//import com.adamkorzeniak.HRS.user.model.User;
//import com.adamkorzeniak.HRS.user.model.UserDTO;
//import com.adamkorzeniak.HRS.user.repository.UserRepository;
//
////@RunWith(SpringRunner.class)
//@RunWith(MockitoJUnitRunner.class)
//@SpringBootTest
//public class SecurityServiceTest {
//	
//	private final UserDTO userForm = new UserDTO();
//	private final User user = new User();
//	private final User savedUser = new User();
//	private static final String USERNAME = "username";
//	private static final String PASSWORD = "password";
//	private static final String EMAIL = "email@mail";
//	private static final Role ROLE = Role.ADMIN;
//	
//	@Mock
//	UserRepository userRepository;
//	
//	@Mock
//	BCryptPasswordEncoder encoder;
//	
//    @InjectMocks
//	private SecurityService securityService  = new SecurityServiceImpl();
//    
//    @Before
//    public void setUp() {
//    	userForm.setUsername(USERNAME);
//    	userForm.setPassword(PASSWORD);
//    	userForm.setEmail(EMAIL);
//    	userForm.setRole(ROLE);
//    	
//    	user.setUsername(USERNAME);
//    	user.setPassword(PASSWORD);
//    	user.setEmail(EMAIL);
//    	user.setRole(ROLE);
//    	
//    	savedUser.setUsername(USERNAME);
//    	savedUser.setPassword(PASSWORD);
//    	savedUser.setEmail(EMAIL);
//    	savedUser.setRole(ROLE);
//    	savedUser.setId(1L);
//    	
//    	when(userRepository.save(eq(user)))
//    	.thenReturn(savedUser);
//    }
//    
//    @Test(expected = IllegalArgumentException.class)
//    public void Register_NullForm_ThrowsException() {
//    	securityService.register(null);
//    }
//    
//    @Test
//    public void Register_ValidForm_RegisterUser() {
//    	User user = securityService.register(userForm);
//    	
//    	assertNotNull(user);
//    	assertEquals(USERNAME, user.getUsername());
//    	assertEquals(PASSWORD, user.getPassword());
//    	assertEquals(EMAIL, user.getEmail());
//    	assertEquals(ROLE, user.getRole());
//    	assertNotNull(user.getId());
//
//    }
//
//}
