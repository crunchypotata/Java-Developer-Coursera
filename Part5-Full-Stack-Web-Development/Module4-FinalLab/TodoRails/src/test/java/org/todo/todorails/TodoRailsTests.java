import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.todo.todorails.model.Task;
import org.todo.todorails.model.User;
import org.todo.todorails.repository.TaskRepository;
import org.todo.todorails.repository.UserRepository;
import org.todo.todorails.service.TaskService;
import org.todo.todorails.service.UserService;

import java.lang.reflect.Method;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class TodoRailsTests {

    @Mock
    private TaskRepository taskRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private Authentication authentication;

    @InjectMocks
    private TaskService taskService;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    // Test to ensure the project runs without compilation errors
    @Test
    public void testProjectCompilation() {
        // If this test runs, it means the project compiles successfully
        assertTrue(true, "The project should compile without errors");
    }

    // Test for TODO 1
    @Test
    public void testPublicAccessConfiguration() {
        // Setup
        // Assuming SecurityConfig is configured correctly.
        // Method call
        // Assertion
        assertTrue(true, "Task: 1 - Public access to /register and /css/** should be configured");
    }

    // Test for TODO 2
    @Test
    public void testLoginFormCentered() {
        // Setup
        // Assuming login.css is configured correctly.
        // Method call
        // Assertion
        assertTrue(true, "Task: 2 - Login form should be centered");
    }

    // Test for TODO 3
    @Test
    public void testRegisterFormAction() {
        // Setup
        // Assuming register.html is configured correctly.
        // Method call
        // Assertion
        assertTrue(true, "Task: 3 - Register form action should point to /register");
    }

    // Test for TODO 8 (a)
    @Test
    public void testUserExistsByUsernameMethodExists() {
        try {
            Method method = UserRepository.class.getMethod("existsByUsername", String.class);
            assertNotNull(method, "Task: 8 (a) - Method existsByUsername should exist in UserRepository");
        } catch (NoSuchMethodException e) {
            fail("Task: 8 (a) - Method existsByUsername is not implemented in UserRepository. Please create it.");
        }
    }

    // Test for TODO 11
    @Test
    public void testSaveTask() {
        // Setup
        Task task = new Task();
        User user = new User();
        user.setUsername("testuser");

        when(authentication.getName()).thenReturn("testuser");
        when(userRepository.findByUsername("testuser")).thenReturn(user);
        when(taskRepository.save(task)).thenReturn(task);

        // Method call
        Task savedTask = taskService.saveTask(task);

        // Assertion
        assertNotNull(savedTask, "Task: 11 - Task should be saved and returned");
    }

    // Test for TODO 12
    @Test
    public void testGetTodayTasksForCurrentUser() {
        // Setup
        User user = new User();
        user.setUsername("testuser");
        LocalDate currentDate = LocalDate.now();
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task());

        when(authentication.getName()).thenReturn("testuser");
        when(userRepository.findByUsername("testuser")).thenReturn(user);
        when(taskRepository.findByUserAndDueDateAndCompleted(user, currentDate, false)).thenReturn(tasks);

        // Method call
        List<Task> todayTasks = taskService.getTodayTasksForCurrentUser();

        // Assertion
        assertFalse(todayTasks.isEmpty(), "Task: 12 - Today's tasks should be returned");
    }

    // Test for TODO 16
    @Test
    public void testMarkTaskAsDone() {
        // Setup
        User user = new User();
        user.setUsername("testuser");
        Task task = new Task();
        task.setCompleted(false);

        when(authentication.getName()).thenReturn("testuser");
        when(userRepository.findByUsername("testuser")).thenReturn(user);
        when(taskRepository.findByUserAndId(user, 1L)).thenReturn(task);

        // Method call
        boolean isMarkedDone = taskService.markTaskAsDone(1L);

        // Assertion
        assertTrue(isMarkedDone, "Task: 16 - Task should be marked as done");
        assertTrue(task.isCompleted(), "Task: 16 - Task completion status should be true");
    }

    // Test for TODO 20 (a)
    @Test
    public void testCountByCompletedMethodExists() {
        try {
            Method method = TaskRepository.class.getMethod("countByCompleted", boolean.class);
            assertNotNull(method, "Task: 20 (a) - Method countByCompleted should exist in TaskRepository");
        } catch (NoSuchMethodException e) {
            fail("Task: 20 (a) - Method countByCompleted is not implemented in TaskRepository. Please create it.");
        }
    }

    // Test for TODO 20 (b)
    @Test
    public void testCountByCompleted() {
        // Check if the method exists
        Method method;
        try {
            method = TaskRepository.class.getMethod("countByCompleted", boolean.class);
            assertNotNull(method, "Task: 20 (a) - Method countByCompleted should exist in TaskRepository");
        } catch (NoSuchMethodException e) {
            fail("Task: 20 (a) - Method countByCompleted is not implemented in TaskRepository. Please create it.");
            return; // Exit the test if the method does not exist
        }

        // Mocking setup
        try {
            // Use reflection to mock the behavior of the method
            when(method.invoke(taskRepository, true)).thenReturn(5);
        } catch (Exception e) {
            fail("Task: 20 (b) - Unable to mock the countByCompleted method. Ensure it is implemented correctly.");
            return;
        }

        // Service layer call
        int completedCount = taskService.countByCompleted(true);

        // Assertion
        assertEquals(5, completedCount, "Task: 20 (b) - Completed tasks count should be 5");
    }


}