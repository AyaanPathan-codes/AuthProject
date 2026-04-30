package com.auth.auth_app.dtos;

import com.auth.auth_app.enums.Provider;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class UserDto {

    private UUID id;
    private String firstName;
    private String password;
    private String email;
    private Boolean enabled;
    private String image;

    private Instant createdAt;
    private Instant updatedAt;

    private Provider provider;
    private Set<RoleDto> roles = new HashSet<>();

    // 🔥 getters & setters (VERY IMPORTANT)
}