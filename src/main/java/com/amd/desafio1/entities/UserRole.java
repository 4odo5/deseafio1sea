package com.amd.desafio1.entities;

import com.amd.desafio1.enums.Roles;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Roles name;
}
