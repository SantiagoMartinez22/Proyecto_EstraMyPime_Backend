package com.estraMyPime.backend.Model;


import lombok.Data;

@Data
public class UserDTO {
    private Long id;
    private String name;
    private String email;
    private String password;
    private int typeUser;
    private int sizeCompany;
    private int sector;
    private boolean isBookDownloaded;
    private boolean isTestDone;
}

