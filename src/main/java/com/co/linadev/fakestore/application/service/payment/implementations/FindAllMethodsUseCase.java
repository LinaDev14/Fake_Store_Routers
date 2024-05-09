package com.co.linadev.fakestore.application.service.payment.implementations;

import com.co.linadev.fakestore.application.mappers.PaymentMapper;
import com.co.linadev.fakestore.application.service.payment.interfaces.FindAllMethodsPayment;
import com.co.linadev.fakestore.domain.dto.PaymentDto;
import com.co.linadev.fakestore.domain.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
@Service
public class FindAllMethodsUseCase implements FindAllMethodsPayment {

    private final PaymentRepository paymentRepository;
    private final PaymentMapper paymentMapper;

    @Override
    public Flux<PaymentDto> findAllPaymentMethods() {
        return paymentRepository.findAll()
                .map(paymentMapper.mapToDtoPayment());
    }
}
