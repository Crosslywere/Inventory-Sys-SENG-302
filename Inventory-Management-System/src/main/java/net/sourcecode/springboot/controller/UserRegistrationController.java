package net.sourcecode.springboot.controller;

import lombok.AllArgsConstructor;
import net.sourcecode.springboot.service.service.impl.RegistrationRequest;
import net.sourcecode.springboot.service.service.impl.RegistrationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "staff/registration")
@AllArgsConstructor
public class UserRegistrationController {

    private RegistrationService registrationService;

    @PostMapping
    public String register(@RequestBody RegistrationRequest request) {
        return registrationService.register(request);
    }

}
