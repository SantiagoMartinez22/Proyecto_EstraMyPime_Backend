package com.estraMyPime.backend.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.estraMyPime.backend.Model.Student;
import com.estraMyPime.backend.Service.StudentService;
import com.estraMyPime.backend.repository.StudentRepository;
import org.springframework.http.HttpStatus;
import java.util.Optional;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    /**
     * Crea un nuevo estudiante.
     * @param student Los datos del estudiante a crear.
     * @return El estudiante creado.
     */
    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student savedStudent = studentService.save(student);
        return ResponseEntity.created(null).body(savedStudent);
    }

    /**
     * Obtiene todos los estudiantes.
     * @return Una lista de todos los estudiantes.
     */
    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.ok(studentService.findAll());
    }

    /**
     * Obtiene un estudiante por ID.
     * @param id El ID del estudiante.
     * @return El estudiante encontrado.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.findById(id));
    }

    /**
     * Actualiza un estudiante.
     * @param id El ID del estudiante a actualizar.
     * @param studentDetails Los detalles del estudiante a actualizar.
     * @return El estudiante actualizado, o un estado de no encontrado si el estudiante no existe.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student studentDetails) {
        Optional<Student> optionalStudent = studentService.getStudentById(id);
        if (optionalStudent.isPresent()) {
            Student existingStudent = optionalStudent.get();
            // Actualiza los campos necesarios
            existingStudent.setEmail(studentDetails.getEmail());
            existingStudent.setName(studentDetails.getName());
            existingStudent.setHaceParteProyecto(studentDetails.getHaceParteProyecto());
            // Guarda el estudiante actualizado
            studentService.save(existingStudent);
            return new ResponseEntity<>(existingStudent, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Elimina un estudiante por ID.
     * @param id El ID del estudiante a eliminar.
     * @return No Content si la eliminación fue exitosa.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        studentService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

