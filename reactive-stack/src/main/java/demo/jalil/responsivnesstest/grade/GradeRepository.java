package demo.jalil.responsivnesstest.grade;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GradeRepository extends ReactiveCrudRepository<Grade, String> {
}
