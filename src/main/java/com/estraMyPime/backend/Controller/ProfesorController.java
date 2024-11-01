package com.estraMyPime.backend.Controller;

import com.estraMyPime.backend.Model.Profesor;
import com.estraMyPime.backend.Service.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



import java.util.Optional;

@RestController
@RequestMapping("/api/teachers")
@CrossOrigin(origins = "*") // Configura CORS
public class ProfesorController {

    @Autowired
    private ProfesorService profesorService;

    // Buscar profesor por ID o email
    @GetMapping
    public Optional<Profesor> searchProfesor(@RequestParam(required = false) Long id,
                                             @RequestParam(required = false) String email) {
        return profesorService.getProfesorByIdOrEmail(id, email);
    }

    // Agregar o actualizar un profesor en el sistema
    @PostMapping
    public Profesor addProfesor(@RequestBody Profesor profesor) {
        return profesorService.saveProfesor(profesor);
    }

    // Actualizar campo profesorParteProyecto
    @PatchMapping("/{id}")
    public Profesor updateProfesorParteProyecto(@PathVariable Long id,
                                                @RequestBody Profesor update) {
        return profesorService.updateProfesorParteProyecto(id, update.getprofesorParteProyecto());
    }
}