package com.auth.auth_app.service;

import com.auth.auth_app.dtos.UserDto;

import java.util.List;

public interface UserService {

    UserDto getUser();
    UserDto getUserById();
    UserDto getUserByEmail(String email);
    UserDto createUser(UserDto userDto);
    UserDto updateUser(UserDto userDto);
    void deleteUser(UserDto userDto);
    List<UserDto> getAllUsers();
}
