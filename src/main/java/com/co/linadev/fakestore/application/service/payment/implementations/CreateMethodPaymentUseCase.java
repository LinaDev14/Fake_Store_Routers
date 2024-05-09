package com.co.linadev.fakestore.application.service.payment.implementations;

import com.co.linadev.fakestore.application.mappers.PaymentMapper;
import com.co.linadev.fakestore.application.service.payment.interfaces.CreateMethodPayment;
import com.co.linadev.fakestore.domain.dto.PaymentDto;
import com.co.linadev.fakestore.domain.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class CreateMethodPaymentUseCase implements CreateMethodPayment {

    private final PaymentRepository paymentRepository;
    private final PaymentMapper paymentMapper;

    @Override
    public Mono<PaymentDto> saveMethodPayment(PaymentDto paymentDto) {
        return paymentRepository.save(paymentMapper.mapToCollectionPayment()
                        .apply(paymentDto))
                .map(paymentMapper.mapToDtoPayment());
    }
}
