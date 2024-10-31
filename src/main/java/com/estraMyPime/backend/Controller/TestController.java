package com.estraMyPime.backend.Controller;

import com.estraMyPime.backend.Model.Test;
import com.estraMyPime.backend.Service.TestService;
import com.estraMyPime.backend.repository.TestRepository;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1")
public class TestController {

    private final TestService testService;

    @Autowired
    public TestController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping("tests")
    public ResponseEntity<Iterable<Test>> getAllTests() {
        return ResponseEntity.ok(testService.getAllTests());
    }

    @GetMapping("test/{id}")
    public ResponseEntity<Test> getTest(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(testService.getTest(id));
        }catch (Exception e) {
            return  ResponseEntity.status(502).body(null);
        }
    }

    @PostMapping("test")
    public ResponseEntity<String> createTest(@RequestBody Test test) {
        return ResponseEntity.ok(testService.createTest(test));
    }

    @DeleteMapping("test/{id}")
    public ResponseEntity<String> deleteTest(@PathVariable Integer id) {
      return ResponseEntity.ok(testService.deleteTest(id));
    }

    @PutMapping("test/{id}")
    public ResponseEntity<String> updateTest(@PathVariable Integer id, @RequestBody Test newtest) {
       return ResponseEntity.ok(testService.updateTest(id,newtest));
    }
}
