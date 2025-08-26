package org.todo.todorails.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.todo.todorails.model.Task;
import org.todo.todorails.service.TaskService;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Controller
public class TaskController {

    @Autowired
    TaskService taskService;

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        // Fetch tasks due today for the current user
        List<Task> todayTasks = taskService.getTodayTasksForCurrentUser();

        /** TODO 13 (a): add the list "todaysTask" object  to the "model"
                         object with the attribute name "todaysTasks"
                        using the method "addAttribute".
         **/
        model.addAttribute("todaysTasks", todayTasks);

        // Fetch all tasks for the current user, sorted by due date
        List<Task> allTasks = taskService.getAllTasksForCurrentUser();
        sortTasksByDueDate(allTasks);

        model.addAttribute("allTasks", allTasks);


        LocalDateTime localDateTime = LocalDateTime.now();
        String formattedDate = DateTimeFormatter.ofPattern("MM/dd/yyyy").format(localDateTime);
        /** TODO 14: send the "formattedDate" to the client with the attribute name "serverTime"
         *           in the model
         **/


        /** TODO 20 (c): For the value of the attributes:
         *                i. completedCount - replace 0 with a call to the method countByCompleted
         *                                    of the taskService with the parameter true.
         *                ii. pendingCount - replace 0 with a call to the method countByCompleted
         *                                    of the taskService with the parameter false.
         **/
        model.addAttribute("completedCount", 0);
        model.addAttribute("pendingCount",0);

        return "dashboard";
    }

    // Method to sort tasks by due date without lambda
    private void sortTasksByDueDate(List<Task> tasks) {
        Collections.sort(tasks, new Comparator<Task>() {
            @Override
            public int compare(Task task1, Task task2) {
                if (task1.getDueDate() == null && task2.getDueDate() == null) {
                    return 0;
                }
                if (task1.getDueDate() == null) {
                    return 1;
                }
                if (task2.getDueDate() == null) {
                    return -1;
                }
                return task1.getDueDate().compareTo(task2.getDueDate());
            }
        });

    }

    @GetMapping("/addtask")
    public String addTask(Model model) {
        model.addAttribute("task", new Task());
        return "addtask";
    }

    @PostMapping("/addtask")
    public String saveTask(@ModelAttribute("task") Task task, Model model, RedirectAttributes redirectAttributes) {
        try {
            /** TODO 11: call the "saveTask" method of the "taskService" to save the task object passed **/
            taskService.saveTask(task);
            redirectAttributes.addFlashAttribute("successMessage", "Task added successfully!");
            return "redirect:/dashboard";
        } catch (Exception e) {
            model.addAttribute("task", model);
            redirectAttributes.addFlashAttribute("errorMessage", "Failed to add task. Please try again.");
            return "redirect:/addtask";
        }

    }

    @PostMapping("/task/markDone")
    public String markTaskAsDone(@RequestParam("taskId") Long taskId, RedirectAttributes redirectAttributes) {

        boolean isMarkedDone = taskService.markTaskAsDone(taskId);

        if (isMarkedDone) {
            redirectAttributes.addFlashAttribute("successMessage", "Task marked as done!");
        } else {
            redirectAttributes.addFlashAttribute("errorMessage", "Failed to mark task as done. You may not have permission.");
        }

        return "redirect:/dashboard"; // Redirect to dashboard with flash message
    }

    @PostMapping("/task/viewtask")
    public String viewTask(@RequestParam("taskId") Long taskId, Model model,  RedirectAttributes redirectAttributes) {

        if(taskId == null ){
            redirectAttributes.addFlashAttribute("errorMessage","Invalid attempt to view task.");
            return "redirect:/dashboard";
        }

        // Fetch the task
        Task task = taskService.getTaskByIdAny(taskId);


        if (task != null) {
            model.addAttribute("task", task);
        } else {
            model.addAttribute("error", "No task to display.");
        }

        return "viewtask";
    }

    @PostMapping("/task/edittask")
    public String editTaskForm(@RequestParam("taskId") Long taskId, Model model) {

        // Fetch the task
        Task task = taskService.getTaskById(taskId);

        if (task != null) {
            model.addAttribute("task", task);
        } else {
            model.addAttribute("error", "No task to display.");
        }

        return "edittask";
    }


    @PostMapping("/updatetask")
    public String updateTask(@ModelAttribute("task") Task task, RedirectAttributes redirectAttributes) {
        try {
            taskService.updateTaskForUser(task);
            redirectAttributes.addFlashAttribute("successMessage", "Task updated successfully!");
            return "redirect:/dashboard";
        } catch (Exception e) {
            System.out.println("Error : " + e);
            redirectAttributes.addFlashAttribute("errorMessage", "Failed to update task. Please try again.");
            return "redirect:/edittask";
        }
    }


    @PostMapping("/task/delete")
    public String deleteTask(@RequestParam("taskId") Long taskId, RedirectAttributes redirectAttributes) {
        // Fetch the task by ID and check if it exists
        Task task = taskService.getTaskByIdAny(taskId);

        if (task != null) {
            // Delete the task
            if (taskService.deleteTask(task)) {
                redirectAttributes.addFlashAttribute("successMessage", "Task deleted successfully.");
            } else {
                redirectAttributes.addFlashAttribute("errorMessage", "Task cannot be deleted by user.");
            }
        } else {
            redirectAttributes.addFlashAttribute("errorMessage", "Task not found.");
        }

        // Redirect to dashboard
        return "redirect:/dashboard";
    }


}

