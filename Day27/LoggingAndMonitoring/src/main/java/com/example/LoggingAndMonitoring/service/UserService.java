package com.example.LoggingAndMonitoring.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private static final Logger logger =
            LoggerFactory.getLogger(UserService.class);

    public String processUser(Long id) {

        logger.trace("Entering processUser()");
        logger.info("Processing user with id: {}", id);

        try {
            if (id == 15) {
                throw new RuntimeException("Simulated exception");
            }
            logger.debug("User processed successfully");
            return "User " + id + " processed successfully";
        } catch (Exception e) {
            logger.error("Error while processing user", e);
            throw e;
        }
    }
}
