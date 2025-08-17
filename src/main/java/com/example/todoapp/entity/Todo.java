package com.example.todoapp.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "todos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title is required")
    @Size(max = 100, message = "Title must not exceed 100 characters")
    @Column(nullable = false, length = 100)
    private String title;

    @Size(max = 500, message = "Description must not exceed 500 characters")
    @Column(length = 500)
    private String description;

    @Column(nullable = false)
    private Boolean completed = false;

    // NEW: Optional deadline field
    @Column(name = "deadline")
    private LocalDateTime deadline;

    @NotNull(message = "User is required")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    // Deadline utility methods
    public boolean hasDeadline() {
        return deadline != null;
    }
    
    public boolean isOverdue() {
        return hasDeadline() && !completed && LocalDateTime.now().isAfter(deadline);
    }
    
    public boolean isDueSoon() {
        if (!hasDeadline() || completed) return false;
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime dueSoonThreshold = now.plusDays(1); // Within 24 hours
        return deadline.isBefore(dueSoonThreshold) && deadline.isAfter(now);
    }
}
