package com.example.usermanagement.controller;

import com.example.usermanagement.impl.UserServiceImpl;
import com.example.usermanagement.model.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;


@RestController
public class UserManagementController {

    @Autowired
    @Qualifier("UserServiceImpl")
    private UserServiceImpl userServiceImpl;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private static final String TOPIC = "user-events";
    private static final Log LOGGER = LogFactory.getLog(UserManagementController.class);

    @PostMapping(value = "/register/user")
    public ResponseEntity<User> register(@RequestBody User user) {
        User userCreated = userServiceImpl.registerUser(user);
        LOGGER.info("putting msg on kafka event to send to journal");
        kafkaTemplate.send(TOPIC, "User created having username : " + userCreated.getUserName());
        return ResponseEntity.ok(userCreated);
    }


    @GetMapping(value = "/user/{userId}")
    public ResponseEntity<User> getUserByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(userServiceImpl.loadUserByUserId(userId));
    }

    @PutMapping(value = "/update/user/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable Long userId,@RequestBody User userDetails) {
        userDetails.setUserId(userId);
        User updatedUser = userServiceImpl.updateUser(userDetails);
        LOGGER.info("putting msg on kafka event to send to journal");
        kafkaTemplate.send(TOPIC, "User updated having username: " + updatedUser.getUserName());
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping(value = "/delete/user/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
        userServiceImpl.deleteUser(userId);
        LOGGER.info("putting msg on kafka event to send to journal");
        kafkaTemplate.send(TOPIC, "User deleted having userId : " + userId);
        return ResponseEntity.noContent().build();
    }

}
