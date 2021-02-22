package demo.jalil.responsivnesstest;

import demo.jalil.responsivnesstest.grade.Grade;
import demo.jalil.responsivnesstest.grade.GradeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component @RequiredArgsConstructor
public class GradeSeeder implements CommandLineRunner {
    private final GradeRepository gradeRepository;

    @Override
    public void run(String... args) throws Exception {
        Flux.just(new Grade("1", 80.0, "Ahmad"),
                new Grade("2", 90.0, "Ali"),
                new Grade("3", 70.0, "Jalil"),
                new Grade("4", 88.0, "Adnan"),
                new Grade("5", 42.0, "Craig")).
                flatMap(gradeRepository::save).// why flatMap, because save return a Mono. so if we use map we will end up with a Flux of Monos
                subscribe();
    }
}
