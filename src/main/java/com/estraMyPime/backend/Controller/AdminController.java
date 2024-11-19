package com.estraMyPime.backend.Controller;

import java.util.List;


// import org.hibernate.mapping.List;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import com.estraMyPime.backend.Model.Admin;
import com.estraMyPime.backend.repository.AdminRepository;
@Tag(name = "Admin Controller", description = "Controlador para la administración")
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class AdminController {
    
    @Autowired
    private AdminRepository adminRepo;
    @Operation(summary = "Crear un nuevo administrador")
    @PostMapping("/admins")//funciona
    public void createAdmin(@RequestBody Admin admi){
        adminRepo.save(admi);
    }
    @Operation(summary = "Obtener todos los administradores")
    @GetMapping("/admins")//funciona
    public List<Admin> seeAdmin(){
        return adminRepo.findAll();
    }
    @Operation(summary = "Eliminar un administrador por ID")
    @DeleteMapping("/admins")//funciona
    public void deleteAdmin(@RequestParam(value = "id") Long id){
        adminRepo.deleteById(id);
    }
    @Operation(summary = "Actualizar un administrador")
    @PutMapping("/admins")
    public void updateAdmin(@RequestParam(value = "id") Long id, @RequestBody Admin admi){
        adminRepo.deleteById(id);
        adminRepo.save(admi);
    }
}
