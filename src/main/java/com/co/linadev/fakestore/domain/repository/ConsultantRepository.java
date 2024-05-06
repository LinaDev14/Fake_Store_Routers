package com.co.linadev.fakestore.domain.repository;

import com.co.linadev.fakestore.domain.collections.Consultant;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ConsultantRepository extends ReactiveMongoRepository<Consultant, String> {
}
