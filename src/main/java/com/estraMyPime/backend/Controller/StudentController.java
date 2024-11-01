package com.estraMyPime.backend.Controller;

import com.estraMyPime.backend.Model.Student;
import com.estraMyPime.backend.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/api/students")
@CrossOrigin(origins = "*") // Configura CORS

public class StudentController {

    @Autowired
    private StudentService studentService;

    // Buscar estudiante por ID o email
    @GetMapping
    public Optional<Student> searchStudent(@RequestParam(required = false) Long id, @RequestParam(required = false) String email) {
        return studentService.getStudentByIdOrEmail(id, email);
    }

    // Agregar o actualizar un estudiante en el sistema
    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    // Actualizar campo studentParteProyecto
    @PatchMapping("/{id}")
    public Student updateHaceParteProyecto(@PathVariable Long id,@RequestBody Student update) {
        return studentService.updateHaceParteProyecto(id, update.getHaceParteProyecto());
    }
}
