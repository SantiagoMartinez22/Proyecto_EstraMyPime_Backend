package com.estraMyPime.backend.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;



@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;


    @Column(unique = true, nullable = false)

    private String email;
    private String name;
    private boolean haceParteProyecto = true;

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

    public Boolean getHaceParteProyecto() {
        return haceParteProyecto;
    }

    public void setHaceParteProyecto(Boolean haceParteProyecto) {
        this.haceParteProyecto = haceParteProyecto;
    }
}
