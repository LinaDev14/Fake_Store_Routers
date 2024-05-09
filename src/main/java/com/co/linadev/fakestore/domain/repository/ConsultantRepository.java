package com.co.linadev.fakestore.domain.repository;

import com.co.linadev.fakestore.domain.collections.Consultant;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultantRepository extends ReactiveMongoRepository<Consultant, String> {
}
