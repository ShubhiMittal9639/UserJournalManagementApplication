package com.example.usermanagement.services;

import com.example.usermanagement.model.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


public interface UserService {

    User registerUser(User user);

    User updateUser(User userDetails);

    void deleteUser(Long userId);

    User loadUserByUserId(Long userId);
}
