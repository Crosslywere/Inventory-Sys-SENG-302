package net.sourcecode.springboot.service.service.impl;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class RegistrationRequest {
    public final String firstName;
    public final String lastName;
    public final String password;
    public final String email;
}
