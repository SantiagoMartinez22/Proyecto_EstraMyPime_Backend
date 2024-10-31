package com.estraMyPime.backend.Service;

import com.estraMyPime.backend.Model.Test;
import com.estraMyPime.backend.repository.TestRepository;
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

    public Iterable<Test> getAllTests() {
        return testRepository.findAll();
    }


    public Test getTest(Integer id) {
        return testRepository.findById(id)
                .orElseThrow(NoSuchElementException::new);
    }


    public String createTest( Test test) {
        Test newTest = testRepository.save(test);
        return "Test creado";
    }


    public String deleteTest(Integer id) {
       testRepository.deleteById(id);
       return "Test eliminado";
    }

    public String updateTest(Integer id, Test newtest) {
       Optional<Test> test = testRepository.findById(id);
       test.ifPresent(t -> {
           newtest.setId(id);
           testRepository.save(newtest);
       });
       return "Actualizado correctamente";
    }
}
