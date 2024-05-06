package com.co.linadev.fakestore.domain.repository;

import com.co.linadev.fakestore.domain.collections.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface UserRepository extends ReactiveMongoRepository<User, String> {

    Mono<User> findByEmailUser(String email);
}
