package com.auth.auth_app.service;

import com.auth.auth_app.enums.Provider;
import com.auth.auth_app.exceptions.ResourceNotFound;
import com.auth.auth_app.exceptions.UserNotFound;
import com.auth.auth_app.helpers.UserHelper;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional(readOnly = true)
    @Override
    public UserDto getUserById(UUID id) {
        User user =  userRepository.findById(id).orElseThrow(()-> new UserNotFound("User not found"));
        return modelMapper.map(user, UserDto.class);
    }

    @Override
    public UserDto getUserByEmail(String email) {

        User user = userRepository.findByEmail(email).orElseThrow(()-> new ResourceNotFound("Cannot find user by Email"));
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
       User existinguser =  userRepository.findById(id).orElseThrow(()-> new UserNotFound("User not found"));
       if(userDto.getFirstName() != null ){
           existinguser.setFirstName(userDto.getFirstName());
       }
       if(userDto.getImage() != null ){
           existinguser.setImage(userDto.getImage());
       }
       if(userDto.getPassword() != null ){
           existinguser.setPassword(userDto.getPassword());
       }
       if(userDto.getProvider() != null){
           existinguser.setProvider(userDto.getProvider());
       }

        return modelMapper.map(existinguser,UserDto.class);
    }

    @Override
    @Transactional
    public void deleteUser(UUID userId) {
     User user =  userRepository.findById(userId).orElseThrow(()-> new UserNotFound("User not found"));
      userRepository.deleteById(userId);
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream().map(user -> modelMapper.map(user,UserDto.class)).toList();
    }
}