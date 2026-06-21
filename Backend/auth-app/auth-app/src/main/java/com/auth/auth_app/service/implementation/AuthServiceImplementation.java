package com.auth.auth_app.service.implementation;


import com.auth.auth_app.dtos.UserDto;
import com.auth.auth_app.service.AuthService;
import com.auth.auth_app.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class AuthServiceImplementation implements AuthService {


    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    @Override
    public UserDto registerUser(UserDto userDto) {

        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
       return userService.createUser(userDto);
    }
}
