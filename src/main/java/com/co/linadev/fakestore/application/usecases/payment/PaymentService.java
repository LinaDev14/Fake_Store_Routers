package com.co.linadev.fakestore.application.usecases.payment;

import com.co.linadev.fakestore.application.mappers.PaymentMapper;
import com.co.linadev.fakestore.domain.dto.PaymentDto;
import com.co.linadev.fakestore.domain.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class PaymentService implements PaymentServiceInterface{

    private final PaymentRepository paymentRepository;
    private final PaymentMapper paymentMapper;

    @Override
    public Mono<PaymentDto> saveMethodPayment(PaymentDto paymentDto) {
        return paymentRepository.save(paymentMapper.mapToCollectionPayment()
                .apply(paymentDto))
                .map(paymentMapper.mapToDtoPayment());
    }

    @Override
    public Flux<PaymentDto> findAllPaymentMethods() {
        return paymentRepository.findAll()
                .map(paymentMapper.mapToDtoPayment());
    }
}
