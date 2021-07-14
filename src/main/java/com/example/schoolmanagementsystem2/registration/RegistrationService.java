package com.example.schoolmanagementsystem2.registration;

import com.example.schoolmanagementsystem2.appuser.AppUser;
import com.example.schoolmanagementsystem2.appuser.AppUserRole;
import com.example.schoolmanagementsystem2.appuser.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final AppUserService appUserService;
    private final EmailValidator emailValidator;

    public String register(RegistrationRequest request) {
        boolean isValidEmail = emailValidator.
                test(request.getEmail());

        if (!isValidEmail) {
            throw new IllegalStateException("email not valid");
        }

        if(request.getRole() == 0) {
            return appUserService.signUpUser(
                    new AppUser(
                            request.getFirstName(),
                            request.getLastName(),
                            request.getEmail(),
                            request.getPassword(),
                            AppUserRole.ADMIN
                    )
            );
        } else if (request.getRole() == 1) {
            return appUserService.signUpUser(
                    new AppUser(
                            request.getFirstName(),
                            request.getLastName(),
                            request.getEmail(),
                            request.getPassword(),
                            AppUserRole.TEACHER
                    )
            );
        } else {
            return appUserService.signUpUser(
                    new AppUser(
                            request.getFirstName(),
                            request.getLastName(),
                            request.getEmail(),
                            request.getPassword(),
                            AppUserRole.STUDENT
                    )
            );
        }

    }

}
