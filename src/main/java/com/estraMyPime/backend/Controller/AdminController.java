package com.estraMyPime.backend.Controller;

import java.util.List;


// import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.estraMyPime.backend.Model.Admin;
import com.estraMyPime.backend.repository.AdminRepository;

@RestController
public class AdminController {
    
    @Autowired
    private AdminRepository adminRepo;

    @PostMapping("/admins")//funciona
    public void createAdmin(@RequestBody Admin admi){
        adminRepo.save(admi);
    }

    @GetMapping("/admins")//funciona
    public List<Admin> seeAdmin(){
        return adminRepo.findAll();
    }

    @DeleteMapping("/admins")//funciona
    public void deleteAdmin(@RequestParam(value = "id") Long id){
        adminRepo.deleteById(id);
    }

    @PutMapping("/admins")
    public void updateAdmin(@RequestParam(value = "id") Long id, @RequestBody Admin admi){
        adminRepo.deleteById(id);
        adminRepo.save(admi);
    }
}
