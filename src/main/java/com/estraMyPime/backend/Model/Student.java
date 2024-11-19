package com.estraMyPime.backend.Model;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "students")
public class Student {

    @Id
    private Long id;

    @Column(unique = true, nullable = false)
    private String email;

    private String name;

    @Column(name = "haceParteProyecto")
    private boolean haceParteProyecto;

    @ManyToOne
    @JoinColumn(name = "teacher_id", nullable = true)
    private Profesor profesor;

    @ManyToMany
    @JoinTable(
            name = "empresa_student_teacher",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "empresa_id")
    )
    private List<User> empresas;

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

    public boolean getHaceParteProyecto() {
        return haceParteProyecto;
    }

    public void setHaceParteProyecto(boolean haceParteProyecto) {
        this.haceParteProyecto = haceParteProyecto;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public List<User> getEmpresas() {
        return empresas;
    }

    public void setEmpresas(List<User> empresas) {
        this.empresas = empresas;
    }
// Getters y setters
}

