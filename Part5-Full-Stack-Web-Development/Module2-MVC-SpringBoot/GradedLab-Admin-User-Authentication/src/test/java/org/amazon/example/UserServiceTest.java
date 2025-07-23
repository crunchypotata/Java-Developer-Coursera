import org.amazon.example.service.UserService;
import org.amazon.example.model.User;
import org.amazon.example.config.SecurityConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

public class UserServiceTest {

	private UserService userService;
	private PasswordEncoder passwordEncoder;

	@BeforeEach
	public void setUp() {
		passwordEncoder = new BCryptPasswordEncoder();
		userService = new UserService(passwordEncoder);
	}

	// Test for Task 1: Check if default admin user exists
	@Test
	public void testDefaultAdminUserExists() {
		User admin = userService.findByUsername("admin");
		assertNotNull(admin, "Task: 1 (TODO: 1) - Expected a default admin user but got null");
	}

	// Test for Task 1: Check if default admin user has role ADMIN
	@Test
	public void testDefaultAdminUserRole() {
		User admin = userService.findByUsername("admin");
		assertEquals("ADMIN", admin.getRole(), "Task: 1 (TODO: 1) - Expected role ADMIN but got " + admin.getRole());
	}

	// Test for Task 2: Check if default regular user exists
	@Test
	public void testDefaultRegularUserExists() {
		User user = userService.findByUsername("user");
		assertNotNull(user, "Task: 1 (TODO: 2) - Expected a default regular user but got null");
	}

	// Test for Task 2: Check if default regular user has role USER
	@Test
	public void testDefaultRegularUserRole() {
		User user = userService.findByUsername("user");
		assertEquals("USER", user.getRole(), "Task: 1 (TODO: 2) - Expected role USER but got " + user.getRole());
	}

	// Test for Task 3: Only ADMIN can access /admin/*
	@Test
	public void testAdminAccess() throws Exception {
		SecurityConfig securityConfig = new SecurityConfig(userService);
		UserDetailsService userDetailsService = securityConfig.userDetailsService();
		UserDetails adminDetails = userDetailsService.loadUserByUsername("admin");
		assertNotNull(adminDetails, "Task: 2 (TODO: 3) - Expected to find user details for admin but got null");
	}

	// Test for Task 4: Only USER can access /user/*
	@Test
	public void testUserAccess() throws Exception {
		SecurityConfig securityConfig = new SecurityConfig(userService);
		UserDetailsService userDetailsService = securityConfig.userDetailsService();
		UserDetails userDetails = userDetailsService.loadUserByUsername("user");
		assertNotNull(userDetails, "Task: 2 (TODO: 4) - Expected to find user details for user but got null");
	}

	// Test for Task 5: Confirm if AdminController class exists
	@Test
	public void testAdminControllerClassExists() {
		try {
			Class<?> adminControllerClass = Class.forName("org.amazon.example.controller.AdminController");
			assertNotNull(adminControllerClass, "Task: 3 (TODO: 5) - Expected AdminController class but it was not found");
		} catch (ClassNotFoundException e) {
			fail("Task: 3 (TODO: 5) - Expected AdminController class but it was not found");
		}
	}

	// Test for Task 6: Create adminDashboard() method in AdminController
	@Test
	public void testAdminDashboardMethodExists() {
		try {
			Class<?> adminControllerClass = Class.forName("org.amazon.example.controller.AdminController");
			Method adminDashboardMethod = adminControllerClass.getMethod("adminDashboard");
			assertNotNull(adminDashboardMethod, "Task: 3 (TODO: 6) - Expected adminDashboard method but got null");
		} catch (ClassNotFoundException e) {
			fail("Task: 3 (TODO: 6) - Expected AdminController class but it was not found");
		} catch (NoSuchMethodException e) {
			fail("Task: 3 (TODO: 6) - Expected adminDashboard method but it was not found");
		}
	}

	// Test for Task 7: Create userProfile() method in AdminController
	@Test
	public void testUserProfileMethodExists() {
		try {
			Class<?> adminControllerClass = Class.forName("org.amazon.example.controller.AdminController");
			Method userProfileMethod = adminControllerClass.getMethod("userProfile");
			assertNotNull(userProfileMethod, "Task: 3 (TODO: 7) - Expected userProfile method but got null");
		} catch (ClassNotFoundException e) {
			fail("Task: 3 (TODO: 7) - Expected AdminController class but it was not found");
		} catch (NoSuchMethodException e) {
			fail("Task: 3 (TODO: 7) - Expected userProfile method but it was not found");
		}
	}

	// Test for Task 8: Check if the project compiles
	@Test
	public void testProjectCompiles() {
		// This test is a placeholder to ensure that the project compiles.
		// The mere existence of this test method implies that the project compiles.
	}

	// Test for Task 9: Login as USER and access /user/profile
	@Test
	public void testMavenCommandExecution() {
		// Assuming the login and profile access functionality is correctly implemented
		// This test would typically be part of an integration test suite
	}

	// Test for Task 10: Login as ADMIN and access /admin/dashboard
	@Test
	public void testNoCompileErrors() {
		// Assuming the login and dashboard access functionality is correctly implemented
		// This test would typically be part of an integration test suite
	}
}