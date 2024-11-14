package com.estraMyPime.backend.Service;

import com.estraMyPime.backend.Model.Student;
import com.estraMyPime.backend.Model.User;
import com.estraMyPime.backend.repository.StudentRepository;
import com.estraMyPime.backend.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpresaService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private UserRepository userRepository;

    public void asignarEstudianteAEmpresa(Long empresaId, Long studentId) {
        User empresa = userRepository.findById(empresaId)
                .orElseThrow(() -> new EntityNotFoundException("Empresa no encontrada"));
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new EntityNotFoundException("Estudiante no encontrado"));

        if (student.getProfesor() == null) {
            throw new IllegalStateException("El estudiante debe tener un profesor asignado antes de asignarlo a una empresa");
        }

        empresa.getEstudiantes().add(student);
        userRepository.save(empresa);
    }
}


