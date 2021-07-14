package com.example.schoolmanagementsystem2.gradelevel;

public class GradeLevelNotFoundException extends RuntimeException {
    public GradeLevelNotFoundException(Long id)  {
        super("Could not find grade " + id);
    }
}

