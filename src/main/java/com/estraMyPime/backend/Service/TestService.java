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

    public List<Test> getAllTests() {
        return testRepository.findAll();
    }

    public List<Test> getTestsByUserId(Long userId) {
        return testRepository.findByUserId(userId);
    }

    public Test createTest(Test test) {
        // Verificar que el user no sea null
        if (test.getUser() == null || test.getUser().getId() == null) {
            throw new RuntimeException("El usuario no puede ser nulo al crear un Test");
        }

        // Buscar el usuario en la base de datos para asegurarse de que existe
        User user = userService.getUserById(test.getUser().getId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        // Asignar el usuario encontrado al Test
        test.setUser(user);

        Test savedTest = testRepository.save(test);
        userService.updateIsTestDone(test.getUser().getId(), true);
        return savedTest;
    }




    public Optional<Test> getTest(Long testId) {
        return testRepository.findById(testId);
    }

    @Transactional
    public Test updateTest(Long id, Test testDetails) {
        Test test = testRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Test not found with id: " + id));

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

    public void deleteTest(Long id) {
        testRepository.deleteById(id);
    }
}

