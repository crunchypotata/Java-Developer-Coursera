package org.todo.todorails.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.todo.todorails.model.Task;
import org.todo.todorails.model.User;
import org.todo.todorails.repository.TaskRepository;
import org.todo.todorails.repository.UserRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;

    // Method to save a new task
    public Task saveTask(Task task) {
        // Get the current authenticated user
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // Get the username
        String username = authentication.getName();

        // Get the user object
        User user = userRepository.findByUsername(username);

        // Set the user who is saving the task
        task.setUser(user);

        // Set the current date as the dateAdded when the task is saved
        task.setDateAdded(LocalDate.now());
        return taskRepository.save(task);
    }


    // Get today's tasks for user
    public List<Task> getTodayTasksForCurrentUser() {
        // Get the current authenticated user
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // Get the username
        String username = authentication.getName();

        // Get the user object
        User user = userRepository.findByUsername(username);


        // Get current date
        LocalDate currentDate = LocalDate.now();

        // Get Task list
        List<Task> taskListForToday = new ArrayList<>();

        /** TODO 12 : Call the method "findByUserAndDueDateAndCompleted"
         *            of the taskRepository object and pass the
         *            user object, currentDate object and status of completed status of false.
         *            assign the value returned to the array list taskListForToday.
          **/


        //return the task list
        return taskListForToday;

    }

    // Method to get all tasks for current user
    public List<Task> getAllTasksForCurrentUser() {
        // Get the current authenticated user
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // Get the username
        String username = authentication.getName();

        // Get the user object
        User user = userRepository.findByUsername(username);

        return taskRepository.findByUser(user);
    }


    // Method to mark a task as done
    public boolean markTaskAsDone(Long taskId) {

        // Get the current authenticated user
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // Get the username
        String username = authentication.getName();

        // Get the user object
        User user = userRepository.findByUsername(username);

        // Get the Task with user combined
        Task task = taskRepository.findByUserAndId(user, taskId);

        if (task != null && !task.isCompleted()) {
            /** TODO 16: set the task completion status to of the "task" object to true **/

            task.setCompletionDate(LocalDate.now());
            taskRepository.save(task);
            return true;
        }

        // Task not found, not owned by user, or already marked done
        return false;
    }

    // Method to get a task which is not done
    public Task getTaskById(Long taskId) {

        // Get the current authenticated user
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // Get the username
        String username = authentication.getName();

        // Get the user object
        User user = userRepository.findByUsername(username);

        // Get the Task with user combined
        Task task = taskRepository.findByUserAndId(user, taskId);

        if (task != null && !task.isCompleted()) {
             return task;
        }

        // Task not found, not owned by user
        return null;
    }

    // Method to get a task which does not look at the done flag
    public Task getTaskByIdAny(Long taskId) {

        // Get the current authenticated user
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // Get the username
        String username = authentication.getName();

        // Get the user object
        User user = userRepository.findByUsername(username);

        // Get the Task with user combined
        Task task = taskRepository.findByUserAndId(user, taskId);

        if (task != null ) {
            return task;
        }

        // Task not found, not owned by user
        return null;
    }

    // Method to update an existing task
    public boolean updateTaskForUser(Task task) {

        // Get the current authenticated user
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // Get the username
        String username = authentication.getName();

        // Get the user object
        User user = userRepository.findByUsername(username);


        // Get task in database
        Task taskInDb = taskRepository.getById(task.getId());

        // if the person who wants to update is not same as the user who created the task
        if(user != null && !user.getUsername().equals(taskInDb.getUser().getUsername())  ) {
            return false;
        }

        Task existingTask = taskRepository.findByUserAndId(user, task.getId());
        if (existingTask != null) {
            existingTask.setTitle(task.getTitle());
            existingTask.setDescription(task.getDescription());
            existingTask.setPriority(task.getPriority());
            existingTask.setDueDate(task.getDueDate());
            existingTask.setType(task.getType());

            // Update the current date as the dateAdded when the task is updated
            existingTask.setDateAdded(LocalDate.now());

            Task taskUpdated = taskRepository.save(existingTask);

            if(taskUpdated != null) {
                return true;
            }
        }

        return false;
    }


    // Method to update an existing task
    public boolean deleteTask(Task task) {

        // Get the current authenticated user
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // Get the username
        String username = authentication.getName();

        // Get the user object
        User user = userRepository.findByUsername(username);

        // Get task in database
        Task taskInDb = taskRepository.getById(task.getId());

        // if the person who wants to update is not same as the user who created the task
        if(user != null && !user.getUsername().equals(taskInDb.getUser().getUsername())  ) {
            return false;
        }

        Task existingTask = taskRepository.findByUserAndId(task.getUser(), task.getId());
        if (existingTask != null) {
            taskRepository.delete(existingTask);
            return true;
        }

        return false;
    }

    public int countByCompleted(boolean completedStatus) {
        /** TODO 20 (b): replace the "return 0" with the value returned from a
         *                call to the respository method  return the count of
         *                tasks based on the completion status from the TaskRespository
         *               which you created in TODO 20 (a)
          **/
        return 0;

    }
}
