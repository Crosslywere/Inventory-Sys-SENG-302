package net.sourcecode.springboot.service.service.impl;

import lombok.AllArgsConstructor;
import net.sourcecode.springboot.model.User;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final UserService userService;
    private final EmailValidator emailValidator;
    public String register(RegistrationRequest request) {
        boolean isValidEmail = emailValidator.test(request.getEmail());
        if (!isValidEmail) {
            throw new IllegalStateException(String.format("%s is not a valid email", request.getEmail()));
        }

        return userService.signUpUser(new User(request.getFirstName(), request.getLastName(), request.getEmail(), request.getPassword()));
    }
}
