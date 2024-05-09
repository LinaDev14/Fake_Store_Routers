package com.co.linadev.fakestore.application.service.order.interfaces;

import com.co.linadev.fakestore.domain.dto.OrderDto;
import reactor.core.publisher.Flux;

public interface FindAllOrders {

    Flux<OrderDto> listOrders();
}
