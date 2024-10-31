package com.estraMyPime.backend.Model;

import jakarta.persistence.*;


@Entity
@Table(name="teachers")
public class Profesor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;


    @Column(unique = true, nullable = false)

    private String email;
    private String name;
    private boolean profesorParteProyecto = true;

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

    public Boolean getprofesorParteProyecto() {
        return profesorParteProyecto;
    }

    public void setprofesorParteProyecto(Boolean profesorParteProyecto) {
        this.profesorParteProyecto = profesorParteProyecto;
    }
}