package com.chatapp.server.model;

import jakarta.persistence.*; // Import all from jakarta.persistence
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;

@Entity // Tells Spring this class is a database entity
@Table(name = "users") // Maps this class to the 'users' table
public class User {

    @Id // Marks this field as the Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increments the ID
    private Long id;

    @Column(nullable = false, unique = true) // Must not be null, must be unique
    private String username;

    @Column(name = "password_hash", nullable = false) // Maps to 'password_hash' column
    private String passwordHash;

    @CreationTimestamp // Automatically sets the time when the user is created
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    // --- Constructors ---
    // A no-argument constructor is required by JPA
    public User() {
    }

    // A convenience constructor for us
    public User(String username, String passwordHash) {
        this.username = username;
        this.passwordHash = passwordHash;
    }

    // --- Getters and Setters ---
    // JPA needs getters and setters to access the fields

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    // A 'toString()' method is great for debugging
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}