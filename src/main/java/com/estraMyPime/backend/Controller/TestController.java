package com.estraMyPime.backend.Controller;

import com.estraMyPime.backend.Model.Test;
import com.estraMyPime.backend.Model.TestDTO;
import com.estraMyPime.backend.Model.User;
import com.estraMyPime.backend.Model.UserDTO;
import com.estraMyPime.backend.Service.TestService;
import com.estraMyPime.backend.repository.TestRepository;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequestMapping("/api/tests")
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class TestController {

    @Autowired
    private TestService testService;

    // @GetMapping("/all")
    // public List<TestDTO> getAllTests() {
    //     List<Test> tests = testService.getAllTests();
    //     return tests.stream()
    //             .map(this::convertToDTO)
    //             .collect(Collectors.toList());
    // }

    // private TestDTO convertToDTO(Test test) {
    //     // User user = test.getUser();
    //     // UserDTO userDTO = new UserDTO(user.getId(), user.getName(), user.getEmail());
    //     // return new TestDTO(test.getId(), test.getPregunta1(), test.getPregunta2(),
    //     //         test.getPregunta3(), test.getPregunta4(), test.getPregunta5(),
    //     //         test.getPregunta6(), test.getPregunta7(), test.getPregunta8(),
    //     //         test.getPregunta9(), userDTO);
    // }

    // Obtener los tests de un usuario específico
    @GetMapping
    public List<Test> getTestsByUserId(@RequestParam Long id) {
        return testService.getTestsByUserId(id);
    }

    // Obtener un test específico por ID
    @GetMapping("/{id}")
    public Optional<Test> getTest(@PathVariable Long id) {
        return testService.getTest(id);
    }

    // Crear un nuevo test
    @PostMapping(consumes = "application/json", produces = "application/json")
    public Test createTest(@RequestBody Test test) {
        return testService.createTest(test);
    }

    // Actualizar un test existente
    @PutMapping("/{id}")
    public Test updateTest(@PathVariable Long id, @RequestBody Test testDetails) {
        return testService.updateTest(id, testDetails);
    }

    // Eliminar un test
    @DeleteMapping("/{id}")
    public void deleteTest(@PathVariable Long id) {
        testService.deleteTest(id);
    }
}



