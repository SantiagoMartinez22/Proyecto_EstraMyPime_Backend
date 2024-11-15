package com.estraMyPime.backend.Controller;

import com.estraMyPime.backend.Model.Test;
import com.estraMyPime.backend.Model.TestDTO;
import com.estraMyPime.backend.Model.User;
import com.estraMyPime.backend.Model.UserDTO;
import com.estraMyPime.backend.Service.TestService;
import com.estraMyPime.backend.repository.TestRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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

@RestController
@RequestMapping("/api/tests")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*", allowCredentials = "true", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.PATCH, RequestMethod.DELETE})
@Tag(name = "Test Controller", description = "Controlador para los test")
public class TestController {

    @Autowired
    private TestService testService;
    @Operation(summary = "Obtiene todos los tests")
    @GetMapping("/all")
    public List<TestDTO> getAllTests() {
        List<Test> tests = testService.getAllTests();
        return tests.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private TestDTO convertToDTO(Test test) {
        User user = test.getUser();
        UserDTO userDTO = new UserDTO(user.getId(), user.getName(), user.getEmail());
        return new TestDTO(test.getId(), test.getPregunta1(), test.getPregunta2(),
                test.getPregunta3(), test.getPregunta4(), test.getPregunta5(),
                test.getPregunta6(), test.getPregunta7(), test.getPregunta8(),
                test.getPregunta9(), userDTO);
    }


    @Operation(summary = "Obtiene por id de usuario")
    @GetMapping
    public List<Test> getTestsByUserId(@RequestParam("userId") Long userId) {
        return testService.getTestsByUserId(userId);
    }
    @Operation(summary = "Obtienen por id del test")
    @GetMapping("/{id}")
    public Optional<Test> getTest(@PathVariable Long id) {
        return testService.getTest(id);
    }
    @Operation(summary = "Crear un nuevo test")
    @PostMapping
    public Test createTest(@RequestBody Test test) {
        return testService.createTest(test);
    }
    @Operation(summary = "Actualizar un test por id")
    @PutMapping("/{id}")
    public Test updateTest(@PathVariable Long id, @RequestBody Test testDetails) {
        return testService.updateTest(id, testDetails);
    }
    @Operation(summary = "Borrar un test por id")
    @DeleteMapping("/{id}")
    public void deleteTest(@PathVariable Long id) {
        testService.deleteTest(id);
    }
}
