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
    private Long id; // ID manual sin autogeneración, usado como documento de identificación

    @Column(nullable = false, length = 255)
    private String name;

    @Column(nullable = false, unique = true, length = 255)
    private String email;

    @Column(nullable = false, length = 255)
    private String password;

    @Column(nullable = false)
    private Integer typeUser;

    private Integer sizeCompany;
    private Integer sector;

    @Column(updatable = false)
    private LocalDateTime registerDate = LocalDateTime.now();

    private boolean isBookDownloaded;
    private boolean isTestDone;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Test> tests;

    @ManyToMany
    @JoinTable(
            name = "empresa_student_teacher",
            joinColumns = @JoinColumn(name = "empresa_id"),
            inverseJoinColumns = @JoinColumn(name = "teacher_id")
    )
    private List<Profesor> profesores;

    @ManyToMany(mappedBy = "empresas")
    private List<Student> estudiantes;

    // Getters y setters
}





