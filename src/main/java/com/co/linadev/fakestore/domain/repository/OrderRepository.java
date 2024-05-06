package com.co.linadev.fakestore.domain.repository;

import com.co.linadev.fakestore.domain.collections.Order;
import com.co.linadev.fakestore.domain.dto.OrderDto;
import com.co.linadev.fakestore.domain.utils.valueObjects.Status;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface OrderRepository extends ReactiveMongoRepository<Order, String> {

    Flux<Order> findByOrderStatus(Status status);
}
