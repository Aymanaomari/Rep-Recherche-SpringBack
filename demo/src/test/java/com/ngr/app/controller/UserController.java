package com.ngr.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ngr.app.dto.UserAccountDTO;
import com.ngr.app.entity.User;
import com.ngr.app.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	
	private static final Logger logger =  LoggerFactory.getLogger(UserService.class);

@Autowired
UserService userService;

public UserController(UserService userService) {
	this.userService=userService;
}

@PostMapping("/register")
public ResponseEntity<User> createUserAndAccount(@RequestBody User user) {
    User response = userService.createUser(user);
    return ResponseEntity.status(HttpStatus.CREATED).body(response);
}


@GetMapping("{UserId}")
public ResponseEntity<?> getUserById(@PathVariable("UserId") String userId) {
    try {
        logger.info("Fetching user with ID: {}", userId);

        // Parse userId to Integer
        int id = Integer.parseInt(userId);

        // Fetch user
        User user = this.userService.getUser(userId);

        // Check if user exists
        if (user != null) {
            logger.info("User found: {}", user);
            return ResponseEntity.status(HttpStatus.OK).body(user);
        } else {
            logger.warn("User with ID {} not found.", id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
    } catch (NumberFormatException e) {
        logger.error("Invalid UserId format: {}", userId);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid UserId format");
    } catch (Exception e) {
        logger.error("Error fetching user: {}", e.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error fetching user");
    }
}

@PutMapping
public ResponseEntity<String> updateUser(@RequestBody User user) {
    try {
        String response = this.userService.updateUser(user);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update user.");
    }
}

@DeleteMapping("/{userId}")
public ResponseEntity<String> deleteUser(@PathVariable("userId") String userId) {
    try {
        String response = this.userService.deleteUser(userId);
        return ResponseEntity.status(HttpStatus.OK).body("User deleted successfully.");
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found or failed to delete.");
    }
}





	
	
}
