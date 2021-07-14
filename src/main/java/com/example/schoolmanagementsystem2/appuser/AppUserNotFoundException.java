package com.example.schoolmanagementsystem2.appuser;

public class AppUserNotFoundException extends RuntimeException {

    public AppUserNotFoundException(Long id) {
        super("Could not find user " + id);
    }
}
