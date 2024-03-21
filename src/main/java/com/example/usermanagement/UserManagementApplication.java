package com.example.usermanagement;

import com.example.usermanagement.controller.UserManagementController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class UserManagementApplication {

    public static void main(String[] args) {

        SpringApplication.run(UserManagementApplication.class,args);
    }

}
