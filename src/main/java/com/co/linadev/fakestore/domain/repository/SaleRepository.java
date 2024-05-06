package com.co.linadev.fakestore.domain.repository;

import com.co.linadev.fakestore.domain.collections.Sale;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface SaleRepository extends ReactiveMongoRepository<Sale, String> {


    Flux<Sale> findSalesByProductId(String productId);

    Mono<Sale> findSalesByOrderId(String orderId);

}
