package com.co.linadev.fakestore.domain.repository;

import com.co.linadev.fakestore.domain.collections.Purchase;
import com.co.linadev.fakestore.domain.utils.valueObjects.Status;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface PurchaseRepository extends ReactiveMongoRepository<Purchase, String> {

    Flux<Purchase> findPurchasesByUserId(String userId);

    Flux<Purchase> findPurchasesByProductId(String productId);

    Flux<Purchase> findPurchaseByStatus(Status status);

}
