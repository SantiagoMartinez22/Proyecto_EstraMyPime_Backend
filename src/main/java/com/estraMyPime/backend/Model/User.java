package com.estraMyPime.backend.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    private Long id; // ID manual, sin autogeneración

    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @Column(name = "email", nullable = false, unique = true, length = 255)
    private String email;

    @Column(name = "password", nullable = false, length = 255)
    private String password;

    @Column(name = "typeUser", nullable = false)
    private Integer typeUser;

    @Column(name = "sizeCompany")
    private Integer sizeCompany;

    @Column(name = "sector")
    private Integer sector;

    @Column(name = "registerDate", updatable = false)
    private LocalDateTime registerDate = LocalDateTime.now();

    @Column(name = "isBookDownloaded")
    private boolean isBookDownloaded;

    @Column(name = "isTestDone")
    private boolean isTestDone;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)

    @JsonIgnore
    private List<Test> tests;

}



