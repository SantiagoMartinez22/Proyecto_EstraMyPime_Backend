package com.estraMyPime.backend.Model;


import jakarta.persistence.*;


@Entity
@Table(name="students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email", unique = true, nullable = false, length = 255)
    private String email;

    @Column(name = "name", nullable = true, length = 255)
    private String name;

    @Column(name = "haceParteProyecto", nullable = true)
    private byte haceParteProyecto;

    @Column(name = "empresa_id", nullable = true)
    private Long empresa_id;

    @Column(name = "profesor_id", nullable = false)
    private Long profesor_id;



    // Getters y setters

    public Long getEmpresa_id() {
        return empresa_id;
    }

    public void setEmpresa_id(Long empresa_id) {
        this.empresa_id = empresa_id;
    }

    public Long getProfesor_id() {
        return profesor_id;
    }

    public void setProfesor_id(Long profesor_id) {
        this.profesor_id = profesor_id;
    }

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

    public byte getHaceParteProyecto() {
        return haceParteProyecto;
    }

    public void setHaceParteProyecto(byte haceParteProyecto) {
        this.haceParteProyecto = haceParteProyecto;
    }
}
