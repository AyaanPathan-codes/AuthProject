package com.auth.auth_app.dtos;

import com.auth.auth_app.enums.Provider;
import com.auth.auth_app.models.Role;
import jakarta.persistence.*;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class UserDto {

    private UUID id;
    private String firstName;
    private String password;


    private String email;
    private String role;
    private Boolean enabled;
    private String image;
    private Instant createdAt =  Instant.now();
    private Instant updatedAt =  Instant.now();

    private Provider provider = Provider.LOCAL;
    private Set<RoleDto> roles = new HashSet<>();
}
