package com.estraMyPime.backend.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
@Data
@Entity
@Table(name = "users")
public class User {

    @Id

    private Long id;

    @Column( name="name",nullable = false, length = 255)
    private String name;

    @Column(name="email",nullable = false, unique = true, length = 255)
    private String email;

    @Column(name="password",nullable = false, length = 255)
    private String password;

    @Convert(converter = TypeUserConverter.class)
    @Enumerated(EnumType.STRING)
    @Column(name="typeUser",nullable = false)
    private TypeUser typeUser;
    @Column(name = "sizeCompany", nullable = true)
    private Integer sizeCompany;
    @Column(name = "sector", nullable = true)
    private Integer sector;

    @Column(name="registerDate",updatable = false)
    private LocalDateTime registerDate = LocalDateTime.now();
    @Column(name = "isBookDownloaded", nullable = true)
    private boolean isBookDownloaded = false;
    @Column(name = "isTestDone", nullable = true)
    private boolean isTestDone = false;

    // Constructors, getters, and setters...
}

