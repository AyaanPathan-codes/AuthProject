package com.auth.auth_app.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
@Builder
@Table(name = "user_role")
public class Role {

    @Id
    private UUID id = UUID.randomUUID();
    @Column(unique = true,nullable = false)
    private String name;
}
