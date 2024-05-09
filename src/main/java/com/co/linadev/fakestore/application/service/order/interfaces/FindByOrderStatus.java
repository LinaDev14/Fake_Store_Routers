package com.co.linadev.fakestore.application.service.order.interfaces;

import com.co.linadev.fakestore.domain.dto.OrderDto;
import com.co.linadev.fakestore.domain.utils.valueObjects.Status;
import reactor.core.publisher.Flux;

public interface FindByOrderStatus {

    Flux<OrderDto> findByOrderStatus(Status status);
}
