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

    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @Column(name = "email", nullable = false, unique = true, length = 255)
    private String email;

    @Column(name = "password", nullable = false, length = 255)
    private String password;


    @Column(name = "typeUser", nullable = false)
    private Integer typeUser;

    @Column(name = "sizeCompany", nullable = true)
    private Integer sizeCompany;

    @Column(name = "sector", nullable = true)
    private Integer sector;

    @Column(name = "registerDate", updatable = false)
    private LocalDateTime registerDate = LocalDateTime.now();

    @Column(name = "isBookDownloaded", nullable = true)
    private boolean isBookDownloaded ;

    @Column(name = "isTestDone", nullable = true)
    private boolean isTestDone ;


    public void setBookDownloaded(boolean bookDownloaded) {
        this.isBookDownloaded = bookDownloaded;
    }
    public void setTestDone(boolean testDone) {
        this.isTestDone = testDone;
    }
}
