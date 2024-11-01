package com.estraMyPime.backend.Service;

import com.estraMyPime.backend.Model.Profesor;
import com.estraMyPime.backend.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
    public class ProfesorService {

        @Autowired
        private ProfesorRepository profesorRepository;

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
            profesor.setprofesorParteProyecto(parteProyecto);
            return profesorRepository.save(profesor);
        }
    }

