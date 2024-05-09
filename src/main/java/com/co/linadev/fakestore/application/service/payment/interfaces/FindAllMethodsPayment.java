package com.co.linadev.fakestore.application.service.payment.interfaces;

import com.co.linadev.fakestore.domain.dto.PaymentDto;
import reactor.core.publisher.Flux;

public interface FindAllMethodsPayment {

    Flux<PaymentDto> findAllPaymentMethods();
}
