package com.estraMyPime.backend.repository;

import com.estraMyPime.backend.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    /**
 * Recupera un Optional que contiene una entidad Student que coincide con el correo electrónico o el id proporcionado.
 *
 * @param email el correo electrónico del estudiante a recuperar
 * @param id el id del estudiante a recuperar
 * @return un Optional que contiene la entidad Student coincidente, o un Optional vacío si no se encuentra ninguna coincidencia
 */
    @Query("SELECT s FROM Student s WHERE s.email = ?1 OR s.id = ?2")
    Optional<Student> findByEmailOrId(String email, Long id);
}


