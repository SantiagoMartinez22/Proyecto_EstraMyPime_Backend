package com.estraMyPime.backend.Controller;

import com.estraMyPime.backend.Model.Test;
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

@RestController
@RequestMapping("/api/tests")
public class TestController {

    private final TestService testService;

    @Autowired
    public TestController(TestService testService) {
        this.testService = testService;
    }

    // Obtener todos los tests
    @GetMapping
    public ResponseEntity<Iterable<Test>> getAllTests() {
        return ResponseEntity.ok(testService.getAllTests());
    }

    // Obtener un test por ID
    @GetMapping("/{id}")
    public ResponseEntity<Test> getTest(@PathVariable Long id) {
        try {
            Test test = testService.getTest(id);
            return ResponseEntity.ok(test);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    // Crear un nuevo test
    @PostMapping("/user/{userId}")
    public ResponseEntity<Void> createTest(@PathVariable Long userId, @RequestBody Test test) {
        try {
            testService.createTest(userId, test);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    // Actualizar un test existente por ID
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateTest(@PathVariable Long id, @RequestBody Test newTest) {
        try {
            testService.updateTest(id, newTest);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // Eliminar un test por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTest(@PathVariable Long id) {
        try {
            testService.deleteTest(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
