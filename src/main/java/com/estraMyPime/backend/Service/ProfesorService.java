package com.estraMyPime.backend.Service;

import com.estraMyPime.backend.Model.Profesor;
import com.estraMyPime.backend.Model.User;
import com.estraMyPime.backend.repository.ProfesorRepository;
import com.estraMyPime.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfesorService {

    @Autowired
    private ProfesorRepository profesorRepository;

    @Autowired
    private UserRepository userRepository;

    public  List<Profesor> getAllTeachers() {
        return profesorRepository.findAll();
    }

    public Optional<Profesor> getProfesorByIdOrEmail(Long id, String email) {
        if (id != null) {
            return profesorRepository.findById(id);
        } else if (email != null && !email.isEmpty()) {
            return profesorRepository.findByEmail(email);
        }
        return Optional.empty();
    }

    public Profesor saveProfesor(Profesor profesor) {
        if (profesor.getId() != null && profesorRepository.existsById(profesor.getId())) {
            throw new RuntimeException("El ID del profesor ya existe");
        }
        return profesorRepository.save(profesor);
    }

    public Profesor updateProfesorParteProyecto(Long id, boolean parteProyecto) {
        Profesor profesor = profesorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Profesor no encontrado"));
        profesor.setProfesorParteProyecto(parteProyecto);
        return profesorRepository.save(profesor);
    }

    public void assignProfesorToCompany(Long profesorId, Long empresaId) {
        Profesor profesor = profesorRepository.findById(profesorId)
                .orElseThrow(() -> new RuntimeException("Profesor no encontrado"));
        User empresa = userRepository.findById(empresaId)
                .orElseThrow(() -> new RuntimeException("Empresa no encontrada"));
        empresa.getProfesores().add(profesor);
        userRepository.save(empresa);
    }
    public void deleteProfesorById(Long id) {
        if (profesorRepository.existsById(id)) {
            profesorRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("El profesor con el ID proporcionado no existe.");
        }
    }
}
