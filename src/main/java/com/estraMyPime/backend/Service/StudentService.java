/**
 * Servicio para gestionar estudiantes.
 */
package com.estraMyPime.backend.Service;

import com.estraMyPime.backend.Model.User;
import com.estraMyPime.backend.repository.UserRepository;
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

    @Autowired
    private UserRepository userRepository;

    public Optional<Student> getStudentByIdOrEmail(Long id, String email) {
        if (id != null) {
            return studentRepository.findById(id);
        } else if (email != null && !email.isEmpty()) {
            return studentRepository.findByEmail(email);
        }
        return Optional.empty();
    }

    public Student saveStudent(Student student) {
        if (student.getId() != null && studentRepository.existsById(student.getId())) {
            throw new RuntimeException("El ID del estudiante ya existe");
        }
        return studentRepository.save(student);
    }

    public Student updateHaceParteProyecto(Long id, boolean haceParteProyecto) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));
        student.setHaceParteProyecto(haceParteProyecto);
        return studentRepository.save(student);
    }

    public void assignStudentToCompany(Long studentId, Long empresaId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));
        if (student.getProfesor() == null) {
            throw new IllegalStateException("El estudiante debe tener un profesor asignado antes de asignarlo a una empresa");
        }
        User empresa = userRepository.findById(empresaId)
                .orElseThrow(() -> new RuntimeException("Empresa no encontrada"));
        empresa.getEstudiantes().add(student);
        userRepository.save(empresa);
    }
}
