package com.co.linadev.fakestore.domain.repository;

import com.co.linadev.fakestore.domain.collections.Product;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface ProductRepository extends ReactiveMongoRepository<Product, String> {

    Flux<Product> findAllByProductIgnoreCase(String productName);

    Flux<Product> findAllByPriceGreaterThan(Double productPrice);

    Flux<Product> findAllByPriceLessThan(Double productPrice);

    Flux<Product> findAllByPrice(Double productPrice);
}
