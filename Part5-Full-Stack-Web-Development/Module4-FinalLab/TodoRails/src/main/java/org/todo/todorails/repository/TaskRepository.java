package org.todo.todorails.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.todo.todorails.model.Task;
import org.todo.todorails.model.User;

import java.time.LocalDate;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    // Find task related to a user and a date
    List<Task> findByUserAndDueDate(User user, LocalDate dueDate);

    // Find tasks by user, due date, and completion status
    List<Task> findByUserAndDueDateAndCompleted(User user, LocalDate dueDate, boolean completed);

    // Find a task by user and taskId
    Task findByUserAndId(User user, Long id);

    // Find a task by user
    List<Task> findByUser(User user);

    // Find task by taskId
    Task getById(Long id);


    /** TODO 20 (a) : add the:
     *               int countByCompleted(boolean completed);
     *               method to count how many tasks are completed
     *              or not based on a boolean value passed representing the completion status.
     **/

}
