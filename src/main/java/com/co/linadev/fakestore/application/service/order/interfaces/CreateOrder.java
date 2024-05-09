package com.co.linadev.fakestore.application.service.order.interfaces;

import com.co.linadev.fakestore.domain.dto.OrderDto;
import reactor.core.publisher.Mono;

public interface CreateOrder {

    Mono<OrderDto> saveOrder(OrderDto orderDto);
}
