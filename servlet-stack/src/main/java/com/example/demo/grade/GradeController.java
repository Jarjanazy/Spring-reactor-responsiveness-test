package com.example.demo.grade;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController @RequiredArgsConstructor
public class GradeController {
    private final GradeRepository gradeRepository;

    @GetMapping("/grade/{id}")
    @CrossOrigin(origins = "*")
    public Grade getGradeById(@PathVariable String id) throws InterruptedException {
        Thread.sleep(1000);
        return gradeRepository.
                findById(Integer.parseInt(id)).
                orElse(new Grade());
    }
}
