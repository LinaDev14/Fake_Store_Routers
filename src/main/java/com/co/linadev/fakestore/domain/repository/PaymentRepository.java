package com.co.linadev.fakestore.domain.repository;

import com.co.linadev.fakestore.domain.collections.Payment;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends ReactiveMongoRepository<Payment, String> {
}
