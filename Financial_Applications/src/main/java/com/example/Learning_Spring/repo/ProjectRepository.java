package com.example.Learning_Spring.repo;
import com.example.Learning_Spring.models.Project;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;
@Repository
public interface ProjectRepository extends ReactiveMongoRepository<Project, String> {
    Mono<Project> findByName(String name);
}
