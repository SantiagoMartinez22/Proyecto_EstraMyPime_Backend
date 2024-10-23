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

    /**
     * Guarda un estudiante.
     * @param student El estudiante a guardar.
     * @return El estudiante guardado.
     */
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    /**
     * Encuentra todos los estudiantes.
     * @return Una lista de todos los estudiantes.
     */
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    /**
     * Encuentra un estudiante por ID.
     * @param id El ID del estudiante.
     * @return El estudiante encontrado.
     * @throws NoSuchElementException si el estudiante no se encuentra.
     */
    public Student findById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Estudiante no encontrado con id " + id));
    }

    /**
     * Elimina un estudiante por ID.
     * @param id El ID del estudiante a eliminar.
     */
    public void delete(Long id) {
        studentRepository.deleteById(id);
    }

    /**
     * Obtiene un estudiante por ID de manera opcional.
     * @param id El ID del estudiante.
     * @return Un Optional con el estudiante encontrado.
     */
    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    /**
     * Actualiza un estudiante.
     * @param id El ID del estudiante a actualizar.
     * @param studentDetails Los detalles del estudiante a actualizar.
     * @return El estudiante actualizado.
     * @throws NoSuchElementException si el estudiante no se encuentra.
     */
    public Student updateStudent(Long id, Student studentDetails) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()) {
            Student existingStudent = optionalStudent.get();
            existingStudent.setEmail(studentDetails.getEmail());
            existingStudent.setName(studentDetails.getName());
            existingStudent.setHaceParteProyecto(studentDetails.getHaceParteProyecto());
            return studentRepository.save(existingStudent);
        } else {
            throw new NoSuchElementException("Estudiante no encontrado con id " + id);
        }
    }
}
