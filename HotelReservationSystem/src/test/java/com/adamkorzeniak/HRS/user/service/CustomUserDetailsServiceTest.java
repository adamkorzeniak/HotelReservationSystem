//package com.adamkorzeniak.HRS.user.service;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
//import static org.mockito.Matchers.any;
//import static org.mockito.Matchers.eq;
//import static org.mockito.Mockito.when;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.runners.MockitoJUnitRunner;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
//import com.adamkorzeniak.HRS.security.Role;
//import com.adamkorzeniak.HRS.user.model.User;
//
////@RunWith(SpringRunner.class)
//@RunWith(MockitoJUnitRunner.class)
//@SpringBootTest
//public class CustomUserDetailsServiceTest {
//	
//	private final String USERNAME = "landlord";
//	private final String PASSWORD = "admin";
//	private final Role ROLE = Role.LANDLORD;
//
//	
//	@Mock
//	private UserService userService;
//	
//    @InjectMocks
//	private UserDetailsService userDetailsService  = new CustomUserDetailsService();
//    
//    @Before
//    public void setUp() {
//		User u = new User();
//		u.setUsername(USERNAME);
//		u.setRole(ROLE);
//		u.setPassword(PASSWORD);
//		
//		when(userService.getUser(any()))
//		.thenReturn(null);
//		
//		when(userService.getUser(eq(USERNAME)))
//		.thenReturn(u);
//    }
//
//	@Test(expected = UsernameNotFoundException.class)
//	public void LoadUserByUsername_NoUser_ThrowException() {
//		userDetailsService.loadUserByUsername("anyone");
//	}
//	
//	@Test
//	public void LoadUserByUsername_ValidUser_UserReturned() {
//		
//		UserDetails userDetails = userDetailsService.loadUserByUsername(USERNAME);
//		assertNotNull(userDetails);
//		assertEquals(USERNAME, userDetails.getUsername());
//		assertEquals(PASSWORD, userDetails.getPassword());
//		List<GrantedAuthority> authorities = new ArrayList<>(userDetails.getAuthorities());
//		assertNotNull(authorities);
//		assertEquals(1, authorities.size());
//		assertEquals("ROLE_" + ROLE, authorities.get(0).getAuthority());
//	}
//
//}
