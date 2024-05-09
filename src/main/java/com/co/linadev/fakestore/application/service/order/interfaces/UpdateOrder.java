package com.co.linadev.fakestore.application.service.order.interfaces;

import com.co.linadev.fakestore.domain.dto.OrderDto;
import reactor.core.publisher.Mono;

public interface UpdateOrder {

    Mono<OrderDto> updateOrder(OrderDto orderDto);
}
