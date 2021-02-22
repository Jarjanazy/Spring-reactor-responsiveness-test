package demo.jalil.responsivnesstest;

import demo.jalil.responsivnesstest.grade.Grade;
import demo.jalil.responsivnesstest.grade.GradeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component @RequiredArgsConstructor
public class GradeSeeder implements CommandLineRunner {
    private final GradeRepository gradeRepository;

    @Override
    public void run(String... args) throws Exception {
        Grade grade = new Grade("1", 80.0, "Ahmad");

        gradeRepository.save(grade).subscribe();
    }
}
