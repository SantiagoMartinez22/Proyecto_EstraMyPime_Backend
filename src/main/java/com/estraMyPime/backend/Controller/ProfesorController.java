package com.estraMyPime.backend.Controller;

import com.estraMyPime.backend.Model.Profesor;
import com.estraMyPime.backend.Model.User;
import com.estraMyPime.backend.Service.ProfesorService;
import com.estraMyPime.backend.Service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/teachers")
@CrossOrigin(origins = "*")
@Tag(name = "Profesor Controller", description = "Operaciones relacionadas con profesores")
public class ProfesorController {

    @Autowired
    private ProfesorService profesorService;

    @Autowired
    private UserService userService;
    @Operation(summary = "Obtener todos los profesores")
    @GetMapping("/all")
    public List<Profesor> getAllProfesores() {
        return profesorService.getAllTeachers();
    }

    @Operation(summary = "Eliminar un profesor por ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProfesor(@PathVariable Long id) {
        profesorService.deleteProfesorById(id);
        return ResponseEntity.ok("Profesor eliminado correctamente");
    }

    @Operation(summary = "Buscar profesor por ID o email")
    @GetMapping
    public Optional<Profesor> searchProfesor(@RequestParam(required = false) Long id,
                                             @RequestParam(required = false) String email) {
        return profesorService.getProfesorByIdOrEmail(id, email);
    }

    @Operation(summary = "Agregar o actualizar un profesor")
    @PostMapping
    public Profesor addProfesor(@RequestBody Profesor profesor) {
        return profesorService.saveProfesor(profesor);
    }

    @Operation(summary = "Actualiza un campo clave para el frontend")
    @PatchMapping("/{id}")
    public Profesor updateProfesorParteProyecto(@PathVariable Long id,
                                                @RequestBody Profesor update) {
        return profesorService.updateProfesorParteProyecto(id, update.getProfesorParteProyecto());
    }

    // Asignar profesor a una empresa
    @PostMapping("/{profesorId}/assign-to-company/{empresaId}")
    public ResponseEntity<String> assignProfesorToCompany(@PathVariable Long profesorId, @PathVariable Long empresaId) {
        profesorService.assignProfesorToCompany(profesorId, empresaId);
        return ResponseEntity.ok("Profesor asignado a la empresa correctamente");
    }
}
