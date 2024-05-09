package com.co.linadev.fakestore.application.service.shipping.interfaces;

import com.co.linadev.fakestore.domain.dto.ShippingDto;
import reactor.core.publisher.Mono;

public interface CreateShipping {

    Mono<ShippingDto> saveShipping(ShippingDto shippingDto);
}
