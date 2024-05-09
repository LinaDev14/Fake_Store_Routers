package com.co.linadev.fakestore.application.service.shipping.implementations;

import com.co.linadev.fakestore.application.service.shipping.interfaces.CreateShipping;
import com.co.linadev.fakestore.domain.dto.ShippingDto;
import reactor.core.publisher.Mono;

public class CreateShippingUseCase implements CreateShipping {

    @Override
    public Mono<ShippingDto> saveShipping(ShippingDto shippingDto) {
        return null;
    }
}
