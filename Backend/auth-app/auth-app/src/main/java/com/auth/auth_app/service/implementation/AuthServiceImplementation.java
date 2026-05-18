package com.auth.auth_app.service.implementation;


import com.auth.auth_app.dtos.UserDto;
import com.auth.auth_app.service.AuthService;
import com.auth.auth_app.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class AuthServiceImplementation implements AuthService {


    private final UserService userService;

    @Override
    public UserDto registerUser(UserDto userDto) {
       UserDto userDto1 = userService.createUser(userDto);
       return userDto1;
    }
}
