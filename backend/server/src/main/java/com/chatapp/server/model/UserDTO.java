package com.chatapp.server.model;

import java.time.LocalDateTime;

// This is a Data Transfer Object (DTO)
// It's a simple, "dumb" class that only holds the data
// we want to send to the frontend.
public class UserDTO {

    private Long id;
    private String username;
    private LocalDateTime createdAt;

    // A constructor to easily convert a User Entity into a UserDTO
    public UserDTO(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.createdAt = user.getCreatedAt();
    }

    // --- Getters are needed for Spring to serialize this to JSON ---
    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}