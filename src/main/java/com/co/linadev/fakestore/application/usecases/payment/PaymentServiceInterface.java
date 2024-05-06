package com.co.linadev.fakestore.application.usecases.payment;

import com.co.linadev.fakestore.domain.dto.PaymentDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PaymentServiceInterface {

    // save payment
    Mono<PaymentDto> saveMethodPayment(PaymentDto paymentDto);

    // find all paymentMethods
    Flux<PaymentDto> findAllPaymentMethods();
}
