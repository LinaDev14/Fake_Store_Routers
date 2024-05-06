package com.co.linadev.fakestore.application.mappers;

import com.co.linadev.fakestore.domain.collections.Payment;
import com.co.linadev.fakestore.domain.dto.PaymentDto;

import java.util.function.Function;

public class PaymentMapper {

    public Function<Payment, PaymentDto> mapToDtoPayment(){

        return payment -> new PaymentDto(
               payment.getId(),
               payment.getPaymentMethod(),
                payment.getDetails()
        );
    }

    public Function<PaymentDto, Payment> mapToCollectionPayment(){

        return paymentDto -> new Payment(
                paymentDto.getId(),
                paymentDto.getPaymentMethod(),
                paymentDto.getDetails()
        );
    }
}
