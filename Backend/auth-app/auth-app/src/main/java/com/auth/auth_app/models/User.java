package com.auth.auth_app.models;

import com.auth.auth_app.enums.Provider;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;


@Entity
@Data
@Builder

@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String firstName;
    private String password;

    @Column(unique = true)
    private String email;
    private String role;
    private Boolean enabled;
    private String image;
    private Instant createdAt =  Instant.now();
    private Instant updatedAt =  Instant.now();
    @Enumerated(EnumType.STRING)
    private Provider provider = Provider.LOCAL;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles",joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
   private Set<Role> roles = new HashSet<>();

}

