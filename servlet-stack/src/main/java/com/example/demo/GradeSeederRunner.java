package com.example.demo;

import com.example.demo.grade.Grade;
import com.example.demo.grade.GradeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
public class GradeSeederRunner implements CommandLineRunner {
    private final GradeRepository gradeRepository;

    @Override
    public void run(String... args){
        List<Grade> grades = Arrays.asList(new Grade(1, 80.0, "Ahmad"),
                new Grade(2, 90.0, "Ali"),
                new Grade(3, 70.0, "Jalil"),
                new Grade(4, 88.0, "Adnan"),
                new Grade(5, 42.0, "Craig"));

        gradeRepository.saveAll(grades);
    }
}
