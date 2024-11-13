package com.estraMyPime.backend.Controller;

import com.estraMyPime.backend.Model.Student;
import com.estraMyPime.backend.Service.StudentService;
import com.estraMyPime.backend.repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RequestMapping("/api/students")
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class StudentController {

    @Autowired
    private StudentRepository studentService;

    // Buscar estudiante por ID o email
    @GetMapping
    public Optional<Student> searchStudent(@RequestParam(required = false) Long id, @RequestParam(required = false) String email) {
        return studentService.findByEmailOrId(email, id);
    }

    // Agregar o actualizar un estudiante en el sistema
    @PostMapping
    public void addStudent(@RequestBody Student student) {
        studentService.save(student);
    }

    // Actualizar campo studentParteProyecto
    @PutMapping
    public void updateHaceParteProyecto(@RequestParam (value = "id") Long id,@RequestBody Student update) {
        studentService.deleteById(id);
        studentService.save(update);
    }
}
