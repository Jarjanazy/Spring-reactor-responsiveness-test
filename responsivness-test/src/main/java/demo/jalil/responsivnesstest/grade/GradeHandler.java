package demo.jalil.responsivnesstest.grade;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component @RequiredArgsConstructor
public class GradeHandler {
    private final GradeRepository gradeRepository;

    public Mono<ServerResponse> gradeHandler(ServerRequest serverRequest){
        String id = serverRequest.pathVariable("id");
        return ServerResponse.
                ok().contentType(MediaType.APPLICATION_JSON).
                body(gradeRepository.findById(id), Grade.class);
    }

}
