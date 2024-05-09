package com.co.linadev.fakestore.application.service.order.interfaces;

import com.co.linadev.fakestore.domain.dto.OrderDto;
import reactor.core.publisher.Flux;

import java.util.List;

public interface SaveAllOrders {

    Flux<OrderDto> saveAllData(List<OrderDto> orders);
}
