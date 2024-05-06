package com.co.linadev.fakestore.domain.repository;

import com.co.linadev.fakestore.domain.collections.Payment;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface PaymentRepository extends ReactiveMongoRepository<Payment, String> {
}
