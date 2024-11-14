package com.estraMyPime.backend.Model;

import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "teachers")
public class Profesor {

    @Id
    private Long id;

    @Column(unique = true, nullable = false)
    private String email;

    private String name;

    private boolean profesorParteProyecto = true;

    @OneToMany(mappedBy = "profesor", cascade = CascadeType.ALL)
    private List<Student> estudiantes;

    // Getters y setters


    // Getters y setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getProfesorParteProyecto() {
        return profesorParteProyecto;
    }

    public void setProfesorParteProyecto(Boolean profesorParteProyecto) {
        this.profesorParteProyecto = profesorParteProyecto;
    }

}


