package com.co.linadev.fakestore.application.service.shipping.interfaces;

import com.co.linadev.fakestore.domain.dto.ShippingDto;
import com.co.linadev.fakestore.domain.utils.valueObjects.ShippingCompany;
import reactor.core.publisher.Flux;

public interface FindShipmentsByCompany {

    Flux<ShippingDto> findShipmentsByCompany(ShippingCompany shippingCompany);
}
