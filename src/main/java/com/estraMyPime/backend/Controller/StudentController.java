package com.estraMyPime.backend.Controller;

import com.estraMyPime.backend.Model.Profesor;
import com.estraMyPime.backend.Model.Student;
import com.estraMyPime.backend.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/students")
@CrossOrigin(origins = "*")
public class StudentController {

    @Autowired
    private StudentService studentService;
    @GetMapping("/all")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }
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

    // Actualizar campo haceParteProyecto
    @PatchMapping("/{id}")
    public Student updateHaceParteProyecto(@PathVariable Long id, @RequestBody Student update) {
        return studentService.updateHaceParteProyecto(id, update.getHaceParteProyecto());
    }

    // Asignar estudiante a una empresa
    @PostMapping("/{studentId}/assign-to-company/{empresaId}")
    public ResponseEntity<String> assignStudentToCompany(@PathVariable Long studentId, @PathVariable Long empresaId) {
        try {
            studentService.assignStudentToCompany(studentId, empresaId);
            return ResponseEntity.ok("Estudiante asignado a la empresa correctamente");
        } catch (IllegalStateException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
