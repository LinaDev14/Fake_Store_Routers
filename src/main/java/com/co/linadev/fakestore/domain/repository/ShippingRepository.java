package com.co.linadev.fakestore.domain.repository;

import com.co.linadev.fakestore.domain.collections.Shipping;
import com.co.linadev.fakestore.domain.dto.ShippingDto;
import com.co.linadev.fakestore.domain.utils.valueObjects.ShippingCompany;
import com.co.linadev.fakestore.domain.utils.valueObjects.Status;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ShippingRepository extends ReactiveMongoRepository<Shipping, String> {

    Flux<Shipping> findShipmentsByStatus(Status status);

    Flux<Shipping> findShipmentsByCompany(ShippingCompany shippingCompany);

    Mono<Shipping> findShippingByOrderId(String orderId);
}
