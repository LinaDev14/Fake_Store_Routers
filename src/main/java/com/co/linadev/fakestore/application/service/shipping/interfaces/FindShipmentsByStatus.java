package com.co.linadev.fakestore.application.service.shipping.interfaces;

import com.co.linadev.fakestore.domain.dto.ShippingDto;
import com.co.linadev.fakestore.domain.utils.valueObjects.Status;
import reactor.core.publisher.Flux;

public interface FindShipmentsByStatus {

    Flux<ShippingDto> findShipmentsByStatus(Status status);
}
