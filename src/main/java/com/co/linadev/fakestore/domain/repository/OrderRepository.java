package com.co.linadev.fakestore.domain.repository;

import com.co.linadev.fakestore.domain.collections.Order;
import com.co.linadev.fakestore.domain.utils.valueObjects.Status;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface OrderRepository extends ReactiveMongoRepository<Order, String> {

    Flux<Order> findOrdersByStatus(Status status);
}
