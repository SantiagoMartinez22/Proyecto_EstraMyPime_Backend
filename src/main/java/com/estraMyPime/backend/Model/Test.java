package com.estraMyPime.backend.Model;


import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "tests")
public class Test {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "pregunta1")
    private String pregunta1;

    @Column(name = "pregunta2")
    private String pregunta2;

    @Column(name = "pregunta3")
    private String pregunta3;

    @Column(name = "pregunta4")
    private String pregunta4;

    @Column(name = "pregunta5")
    private String pregunta5;

    @Column(name = "pregunta6")
    private String pregunta6;

    @Column(name = "pregunta7")
    private String pregunta7;

    @Column(name = "pregunta8")
    private String pregunta8;

    @Column(name = "pregunta9")
    private String pregunta9;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)

    @JsonBackReference
    private User user; // Relación directa con User




}











