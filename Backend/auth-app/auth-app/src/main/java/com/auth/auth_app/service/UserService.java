package com.auth.auth_app.service;

import com.auth.auth_app.dtos.UserDto;
import java.util.List;
import java.util.UUID;

public interface UserService {

    UserDto getUserById(UUID id);

    UserDto getUserByEmail(String email);

    UserDto createUser(UserDto userDto);

    UserDto updateUser(UUID id, UserDto userDto);

    void deleteUser(UUID id);

    List<UserDto> getAllUsers();
}