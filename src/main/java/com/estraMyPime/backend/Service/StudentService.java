/**
 * Servicio para gestionar estudiantes.
 */
package com.estraMyPime.backend.Service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.estraMyPime.backend.Model.Student;
import com.estraMyPime.backend.repository.StudentRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;



    // Obtener estudiante por ID o email
    public Optional<Student> getStudentByIdOrEmail(Long id, String email) {
        if (id != null) {
            return studentRepository.findById(id);
        } else if (email != null && !email.isEmpty()) {
            return studentRepository.findByEmailOrId(email, id);
        }
        return Optional.empty();
    }

    // Guardar o actualizar un estudiante
    public Student saveStudent(Student student) {
        if (student.getId() != null && studentRepository.existsById(student.getId())) {
            throw new RuntimeException("El ID del estudiante ya existe");
        }
        return studentRepository.save(student);
    }

    // Actualizar campoHaceParteProyecto
    public Student updateHaceParteProyecto(Long id, byte haceParteProyecto) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));
        student.setHaceParteProyecto(haceParteProyecto);
        return studentRepository.save(student);
    }



}











