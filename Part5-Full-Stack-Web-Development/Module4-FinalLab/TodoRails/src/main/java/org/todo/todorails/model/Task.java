package org.todo.todorails.model;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Title of task
    private String title;

    // Description of task
    private String description;

    // Priority can be "high", "medium", or "low"
    private String priority;

    // Due date for the task

    @DateTimeFormat(pattern = "yyyy-MM-dd") // Ensure consistent date format
    private LocalDate dueDate;

    // Task type can be "official", "family", or "personal"
    private String type;

    // Date when the task was added
    private LocalDate dateAdded;

    // Flag to indicate if the task is completed
    private boolean completed;

    // Date when the task was marked as completed
    private LocalDate completionDate;

    // Many-to-one relationship with User (each task belongs to a user)
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // Constructors, getters, and setters

    public Task() {
        // Automatically set the creation date when a task is created
        this.dateAdded = LocalDate.now();
        this.completed = false; // By default, a new task is not completed
    }

    // Getter and Setter for id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Getter and Setter for title
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // Getter and Setter for description
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Getter and Setter for priority
    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    // Getter and Setter for dueDate
    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    // Getter and Setter for type
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    // Getter and Setter for dateAdded
    public LocalDate getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(LocalDate dateAdded) {
        this.dateAdded = dateAdded;
    }

    // Getter and Setter for completed
    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
        // Set the completionDate when marking the task as completed
        if (completed && this.completionDate == null) {
            this.completionDate = LocalDate.now();
        } else if (!completed) {
            this.completionDate = null;
        }
    }

    // Getter and Setter for completionDate
    public LocalDate getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(LocalDate completionDate) {
        this.completionDate = completionDate;
    }

    // Getter and Setter for user
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    // Utility method to handle truncation of description to display in dashboard
    public String getShortDescription() {
        return description != null && description.length() > 10
                ? description.substring(0, 10) + "..."
                : description;
    }

}
