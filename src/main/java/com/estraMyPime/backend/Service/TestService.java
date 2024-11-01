package com.estraMyPime.backend.Service;

import com.estraMyPime.backend.Model.Test;
import com.estraMyPime.backend.Model.User;
import com.estraMyPime.backend.repository.TestRepository;
import com.estraMyPime.backend.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Optional;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TestService {

    @Autowired
    private TestRepository testRepository;

    @Autowired
    private UserService userService;

    // Obtener todos los tests
    public List<Test> getAllTests() {
        return testRepository.findAll();
    }

    // Obtener tests por el ID del usuario
    public List<Test> getTestsByUserId(Long userId) {
        return testRepository.findByUserId(userId);
    }

    // Crear un nuevo test y actualizar la bandera isTestDone
    public Test createTest(Test test) {
        // Guardar el test y actualizar isTestDone en el usuario relacionado
        Test savedTest = testRepository.save(test);
        userService.updateIsTestDone(test.getUser().getId(), true);
        return savedTest;
    }

    // Obtener un test por su ID
    public Optional<Test> getTest(Long testId) {
        return testRepository.findById(testId);
    }

    // Actualizar un test existente
    @Transactional
    public Test updateTest(Long id, Test testDetails) {
        Test test = testRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Test not found with id: " + id));

        // Actualizar los detalles del test
        test.setPregunta1(testDetails.getPregunta1());
        test.setPregunta2(testDetails.getPregunta2());
        test.setPregunta3(testDetails.getPregunta3());
        test.setPregunta4(testDetails.getPregunta4());
        test.setPregunta5(testDetails.getPregunta5());
        test.setPregunta6(testDetails.getPregunta6());
        test.setPregunta7(testDetails.getPregunta7());
        test.setPregunta8(testDetails.getPregunta8());
        test.setPregunta9(testDetails.getPregunta9());

        Test updatedTest = testRepository.save(test);
        userService.updateIsTestDone(test.getUser().getId(), true);
        return updatedTest;
    }

    // Eliminar un test
    public void deleteTest(Long id) {
        testRepository.deleteById(id);
    }
}
