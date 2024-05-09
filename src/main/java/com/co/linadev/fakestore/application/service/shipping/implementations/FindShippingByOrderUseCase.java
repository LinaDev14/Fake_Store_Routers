package com.co.linadev.fakestore.application.service.shipping.implementations;

import com.co.linadev.fakestore.application.mappers.ShippingMapper;
import com.co.linadev.fakestore.application.service.shipping.interfaces.FindShippingByOrderId;
import com.co.linadev.fakestore.domain.dto.ShippingDto;
import com.co.linadev.fakestore.domain.repository.ShippingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class FindShippingByOrderUseCase implements FindShippingByOrderId {

    private final ShippingRepository shippingRepository;
    private final ShippingMapper shippingMapper;

    @Override
    public Mono<ShippingDto> findShippingByOrderId(String orderId) {
        return shippingRepository.findShippingByOrderId(orderId)
                .map(shippingMapper.mapToDtoShipping());
    }
}
