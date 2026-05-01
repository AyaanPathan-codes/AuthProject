package com.auth.auth_app.service;

import com.auth.auth_app.enums.Provider;
import com.auth.auth_app.exceptions.ResourceNotFound;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import com.auth.auth_app.dtos.UserDto;
import com.auth.auth_app.models.User;
import com.auth.auth_app.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImplementation implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public UserDto getUserById(UUID id) {
        return null; // implement logic
    }

    @Override
    public UserDto getUserByEmail(String email) {

        User user = userRepository.findByEmail(email).orElseThrow(()-> new ResourceNotFound("User not found by Email"));
        return modelMapper.map(user, UserDto.class);
    }

    @Override
    @Transactional
    public UserDto createUser(UserDto userDto) {

        if(userDto.getEmail() == null || userDto.getEmail().isEmpty()){
            throw new IllegalArgumentException("Email is required");
        }

        if(userRepository.existsByEmail(userDto.getEmail())){
            throw new IllegalArgumentException("Email already exists");
        }

        User user = modelMapper.map(userDto,User.class);
        user.setProvider(userDto.getProvider() !=null?userDto.getProvider(): Provider.LOCAL);
        User savedUser =  userRepository.save(user);
        return modelMapper.map(savedUser,UserDto.class);

    }

    @Override
    public UserDto updateUser(UUID id, UserDto userDto) {
        return null;
    }

    @Override
    public void deleteUser(UUID id) {

    }

    @Override
    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream().map(user -> modelMapper.map(user,UserDto.class)).toList();
    }
}