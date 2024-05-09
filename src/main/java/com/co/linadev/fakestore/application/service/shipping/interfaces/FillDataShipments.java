package com.co.linadev.fakestore.application.service.shipping.interfaces;

import com.co.linadev.fakestore.domain.dto.ShippingDto;
import reactor.core.publisher.Flux;

import java.util.List;

public interface FillDataShipments {

    Flux<ShippingDto> fillDataShipments(List<ShippingDto> shippingDto);
}
