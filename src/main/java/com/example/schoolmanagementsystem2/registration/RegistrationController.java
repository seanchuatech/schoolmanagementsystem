package com.example.schoolmanagementsystem2.registration;

import com.example.schoolmanagementsystem2.appuser.AppUser;
import com.example.schoolmanagementsystem2.appuser.AppUserNotFoundException;
import com.example.schoolmanagementsystem2.appuser.AppUserRepository;
import com.example.schoolmanagementsystem2.appuser.AppUserRole;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;
    private final AppUserRepository appUserRepository;

    @GetMapping("/users")
    List<AppUser> getAllUser() {
        return appUserRepository.findAll();
    }

    @PostMapping("/users/create")
    public String createNewUser(@RequestBody RegistrationRequest request) {
        return registrationService.register(request);
    }

    @GetMapping("/users/{id}")
    AppUser getUser(@PathVariable Long id) {
        return appUserRepository.findById(id).orElseThrow(() -> new AppUserNotFoundException(id));
    }

    @PutMapping("/users/{id}")
    AppUser updateUser(@RequestBody AppUser newUser, @PathVariable Long id) {
        return appUserRepository.findById(id).
                map(appUser -> {
                    appUser.setFirstName(newUser.getFirstName());
                    appUser.setLastName(newUser.getLastName());
                    appUser.setEmail(newUser.getEmail());
                    appUser.setPassword(newUser.getPassword());
                    appUser.setAppUserRole(AppUserRole.TEACHER);
                    return appUserRepository.save(appUser);
                }).
                orElseGet(() -> {
                    newUser.setId(id);
                    return appUserRepository.save(newUser);
                });
    }

    @DeleteMapping("/users/{id}")
    void deleteEmployee(@PathVariable Long id) {
        appUserRepository.deleteById(id);
    }


}
