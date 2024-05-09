package com.co.linadev.fakestore.application.service.shipping.implementations;

import com.co.linadev.fakestore.application.mappers.ShippingMapper;
import com.co.linadev.fakestore.application.service.shipping.interfaces.FindShippingById;
import com.co.linadev.fakestore.domain.dto.ShippingDto;
import com.co.linadev.fakestore.domain.repository.ShippingRepository;
import com.co.linadev.fakestore.domain.utils.messages.ShippingMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class FindShippingByIdUseCase implements FindShippingById {

    private final ShippingRepository shippingRepository;
    private final ShippingMapper shippingMapper;


    @Override
    public Mono<ShippingDto> findByShippingId(String id) {
        return shippingRepository.findById(id)
                .map(shippingMapper.mapToDtoShipping())
                .switchIfEmpty(Mono.error(new RuntimeException(ShippingMessage.SHIPPING_NOT_FOUND)));
    }
}
