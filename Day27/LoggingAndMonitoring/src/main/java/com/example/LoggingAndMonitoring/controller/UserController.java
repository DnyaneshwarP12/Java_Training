package com.example.LoggingAndMonitoring.controller;

import com.example.LoggingAndMonitoring.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private static final Logger logger =
            LoggerFactory.getLogger(UserController.class);

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public String getUser(@PathVariable Long id) {

        logger.info("Received request to fetch user with id: {}", id);

        if (id <= 0) {
            logger.warn("Invalid user id: {}", id);
            return "Invalid user ID";
        }

        String response = userService.processUser(id);
        logger.debug("Response sent for user id: {}", id);

        return response;
    }
}
