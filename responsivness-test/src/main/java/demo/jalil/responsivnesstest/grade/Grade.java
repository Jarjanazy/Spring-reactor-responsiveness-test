package demo.jalil.responsivnesstest.grade;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document @Data @RequiredArgsConstructor @Builder
public class Grade {
    @Id
    private final String id;
    private final double grade;
    private final String studentName;
}
