package com.co.linadev.fakestore.domain.repository;

import com.co.linadev.fakestore.domain.collections.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface UserRepository extends ReactiveMongoRepository<User, String> {

    Mono<User> findUserByEmail(String email);
}
