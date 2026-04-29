package com.auth.auth_app.models;

import com.auth.auth_app.enums.Provider;

import java.time.Instant;
import java.util.HashSet;
import java.util.UUID;

public class User {


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

   private Set<Role> roles = new HashSet<>();

}

