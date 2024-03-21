package com.example.usermanagement.impl;

import com.example.usermanagement.exceptions.UserNotFoundException;
import com.example.usermanagement.model.User;
import com.example.usermanagement.repositories.UserRepository;
import com.example.usermanagement.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("UserServiceImpl")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User registerUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User userDetails) {
        userRepository.findById(userDetails.getUserId())
                .orElseThrow(()->new UserNotFoundException("user not found with it :"+userDetails.getUserId()));
        return userRepository.save(userDetails);
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public User loadUserByUserId(Long userId) {
        Optional<User> user =  userRepository.findById(userId);
        return user.orElse(null);
    }

}
