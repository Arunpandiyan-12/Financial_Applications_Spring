package com.example.Learning_Spring.repo;

import com.example.Learning_Spring.models.Profit;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface ProfitReportRepository extends ReactiveMongoRepository<Profit, String> {
    Flux<Profit> findByYear(int year);
}

