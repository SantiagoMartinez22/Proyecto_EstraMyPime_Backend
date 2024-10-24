package com.estraMyPime.backend.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "admins")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id; 

    @Column(name = "email", length = 255)
    private String email; 

    @Column(name = "password", length = 255)
    private String password; 

    @Column(name = "name", length = 255)
    private String name;

    @Column(name = "lastname", length = 255)
    private String lastname;

    @Column(name = "phoneNumber", length = 20)
    private String phoneNumber;

    // @Column(name = "phone_number", length = 20)
    // private String phone_number;

    public Admin(){

    }


    public void setEmail(String email){
        this.email = email;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setLastname(String lastname){
        this.lastname = lastname;
    }
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }
    // public void setPhone_number(String phone_number){
    //     this.phone_number = phone_number;
    // }


    public String getEmail(){
        return this.email;
    }
    public String getPassword(){
        return this.password;
    }
    public String getName(){
        return this.name;
    }
    public String getLastname(){
        return this.lastname;
    }
    public String getPhoneNumber(){
        return this.phoneNumber;
    }
    // public String getPhone_number(){
    //     return this.phone_number;
    // }
    
}
