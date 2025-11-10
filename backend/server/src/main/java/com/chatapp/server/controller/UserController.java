package com.chatapp.server.controller;

import com.chatapp.server.ServerApplication;
import com.chatapp.server.model.User;
import com.chatapp.server.model.UserDTO;
import com.chatapp.server.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(ServerApplication.class);

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<UserDTO> getAllUsers() {
        log.info("Get Users");
        List<User> original = userRepository.findAll();
        List<UserDTO> sanitizedUsers = original.stream().map(UserDTO::new).collect(Collectors.toList());
        return sanitizedUsers;
    }
}
