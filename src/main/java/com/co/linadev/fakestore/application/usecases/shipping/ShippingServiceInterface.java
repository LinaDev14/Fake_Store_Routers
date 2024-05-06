package com.co.linadev.fakestore.application.usecases.shipping;

import com.co.linadev.fakestore.domain.dto.ShippingDto;
import com.co.linadev.fakestore.domain.utils.valueObjects.ShippingCompany;
import com.co.linadev.fakestore.domain.utils.valueObjects.Status;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface ShippingServiceInterface {

    // saveShipping
    Mono<ShippingDto> saveShipping(ShippingDto shippingDto);

    Flux<ShippingDto> fillDataShipments(List<ShippingDto> shippingDto);

    // list shipping
    Flux<ShippingDto> listShipments();

    // updateShippingStatus
    Mono<ShippingDto> updateShipping(ShippingDto shippingDto);

    Flux<ShippingDto> findShipmentsByStatus(Status status);

    Flux<ShippingDto> findShipmentsByCompany(ShippingCompany shippingCompany);

    // find by id
    Mono<ShippingDto> findByShippingId(String id);

    // find by order ID
    Mono<ShippingDto> findShippingByOrderId(String orderId);



}
