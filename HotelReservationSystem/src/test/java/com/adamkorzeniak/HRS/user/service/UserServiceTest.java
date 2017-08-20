//package com.adamkorzeniak.HRS.user.service;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
//import static org.junit.Assert.assertNull;
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
//import org.springframework.dao.DuplicateKeyException;
//
//import com.adamkorzeniak.HRS.user.model.User;
//import com.adamkorzeniak.HRS.user.repository.UserRepository;
//
////@RunWith(SpringRunner.class)
//@RunWith(MockitoJUnitRunner.class)
//@SpringBootTest
//public class UserServiceTest {
//	
//	private final User EXISTING_USER = new User();
//	private final String EXISTING_USERNAME = "existing";
//	private final User NEW_USER = new User();
//	private final String NEW_USERNAME = "new";
//	
//	@Mock
//	private UserRepository userRepository;
//	
//    @InjectMocks
//	private UserService userService  = new UserServiceImpl();
//    
//    @Before
//    public void setUp() {
//    	EXISTING_USER.setUsername(EXISTING_USERNAME);
//    	NEW_USER.setUsername(NEW_USERNAME);
//    	
//    	when(userRepository.findByUsername(eq(EXISTING_USERNAME)))
//    	.thenReturn(EXISTING_USER);
//    	
//    	when(userRepository.findByUsername(eq(NEW_USERNAME)))
//    	.thenReturn(null);
//    	
//    	User databaseUser = new User();
//    	databaseUser.setUsername(NEW_USER.getUsername());
//    	databaseUser.setId(1L);
//    	
//    	when(userRepository.save(eq(NEW_USER)))
//    	.thenReturn(databaseUser);
//    }
//
//	@Test(expected = DuplicateKeyException.class)
//	public void Register_UserAlreadyExists_ThrowsException() {
//		userService.register(EXISTING_USER);
//	}
//	
//	@Test(expected = IllegalArgumentException.class)
//	public void Register_UserNull_ThrowsException() {
//		userService.register(null);
//	}
//	
//	@Test
//	public void Register_ValidUser_UserAdded() {
//		User user = userService.register(NEW_USER);
//		
//		assertNotNull(user);
//		assertEquals(NEW_USER.getUsername(), user.getUsername());
//		assertNotNull(user.getId());
//	}
//	
//	@Test(expected = IllegalArgumentException.class)
//	public void GetUser_UsernameNull_ThrowsException() {
//		userService.getUser(null);
//	}
//	
//	@Test
//	public void GetUser_UserNotFound_ReturnsNull() {
//		User user = userService.getUser(NEW_USERNAME);
//		
//		assertNull(user);
//	}
//	
//	@Test
//	public void GetUser_UserFound_ReturnsUser() {
//		User user = userService.getUser(EXISTING_USERNAME);
//
//		assertNotNull(user);
//		assertEquals(EXISTING_USERNAME, user.getUsername());
//	}
//
//
//}
