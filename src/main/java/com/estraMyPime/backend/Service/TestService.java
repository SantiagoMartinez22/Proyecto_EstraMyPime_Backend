package com.estraMyPime.backend.Service;

import com.estraMyPime.backend.Model.Test;
import com.estraMyPime.backend.Model.User;
import com.estraMyPime.backend.repository.TestRepository;
import com.estraMyPime.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;
@Service
public class TestService {

    private final TestRepository testRepository;

    @Autowired
    public TestService(TestRepository testRepository) {
        this.testRepository = testRepository;
    }
    @Autowired
    private UserRepository userRepository;

    // Obtener todos los tests
    public Iterable<Test> getAllTests() {
        return testRepository.findAll();
    }

    // Obtener un test específico por ID, lanza excepción si no existe
    public Test getTest(Long id) {
        return testRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Test no encontrado con ID: " + id));
    }

    public void createTest(Long userId, Test test) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NoSuchElementException("Usuario no encontrado con ID: " + userId));
        test.setUser(user);  // Asociar el Test con el User encontrado
        testRepository.save(test);
    }


    // Eliminar un test, lanza excepción si no existe
    public void deleteTest(Long id) {
        if (!testRepository.existsById(id)) {
            throw new NoSuchElementException("No se puede eliminar: Test no encontrado con ID: " + id);
        }
        testRepository.deleteById(id);
    }

    // Actualizar un test existente, lanza excepción si no existe
    public void updateTest(Long id, Test newTest) {
        Test existingTest = testRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("No se puede actualizar: Test no encontrado con ID: " + id));

        newTest.setId(id);  // Aseguramos que se mantiene el mismo ID
        testRepository.save(newTest);  // Guardamos la actualización
    }
}
