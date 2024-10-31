package com.estraMyPime.backend.Model;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name = "tests")
public class Test {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_id")
    @JsonProperty("user_id")
    private Integer userId;

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

    public String getPregunta1() {
        return pregunta1;
    }

    public String getPregunta2() {
        return pregunta2;
    }

    public String getPregunta3() {
        return pregunta3;
    }

    public String getPregunta4() {
        return pregunta4;
    }

    public String getPregunta5() {
        return pregunta5;
    }

    public String getPregunta6() {
        return pregunta6;
    }

    public String getPregunta7() {
        return pregunta7;
    }

    public Integer getId() {
        return id;
    }


    public void setPregunta1(String pregunta1) {
        this.pregunta1 = pregunta1;
    }

    public void setPregunta2(String pregunta2) {
        this.pregunta2 = pregunta2;
    }

    public void setPregunta3(String pregunta3) {
        this.pregunta3 = pregunta3;
    }

    public void setPregunta4(String pregunta4) {
        this.pregunta4 = pregunta4;
    }

    public void setPregunta5(String pregunta5) {
        this.pregunta5 = pregunta5;
    }

    public void setPregunta6(String pregunta6) {
        this.pregunta6 = pregunta6;
    }

    public void setPregunta7(String pregunta7) {
        this.pregunta7 = pregunta7;
    }

    public String getPregunta8() {
        return pregunta8;
    }

    public void setPregunta8(String pregunta8) {
        this.pregunta8 = pregunta8;
    }

    public String getPregunta9() {
        return pregunta9;
    }

    public void setPregunta9(String pregunta9) {
        this.pregunta9 = pregunta9;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setId(Integer id) {
        this.id = id;
    }




}










