package com.co.linadev.fakestore.application.service.shipping.interfaces;

import com.co.linadev.fakestore.domain.dto.ShippingDto;
import reactor.core.publisher.Flux;

public interface FindAllShipments {

    Flux<ShippingDto> listShipments();
}
