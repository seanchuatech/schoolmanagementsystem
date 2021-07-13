package com.example.schoolmanagementsystem2.teacher;

import javax.persistence.Entity;

@Entity
public class Teacher {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
