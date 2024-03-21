package com.example.usermanagement.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "app_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "Id")
    private Long userId;

    @Column(name = "userName",unique = true)
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "contactNumber")
    private String contactNumber;

    @Column(name = "roleName")
    private String roleName;

    @Column(name ="address")
    private String address;

    @Column(name="email")
    private String email;


    public User() {

    }

    public User(String userName, String contactNumber, String roleName, String address, String email) {
        this.userName = userName;
        this.contactNumber = contactNumber;
        this.roleName = roleName;
        this.address = address;
        this.email = email;
    }


}
