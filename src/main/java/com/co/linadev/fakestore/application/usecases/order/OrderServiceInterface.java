package com.co.linadev.fakestore.application.usecases.order;


import com.co.linadev.fakestore.domain.dto.OrderDto;
import com.co.linadev.fakestore.domain.utils.valueObjects.Status;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface OrderServiceInterface {

    // list orders
    Flux<OrderDto> listOrders();

    // find by id
    Mono<OrderDto> findByOrderId(String id);

    // save order
    Mono<OrderDto> saveOrder(OrderDto orderDto);

    // update order
    Mono<OrderDto> updateOrder(OrderDto orderDto);

    // delete order
    Mono<String> deleteOrder(String id);

    // fill Data
    Flux<OrderDto> saveAllData(List<OrderDto> orders);

    // find by status
    Flux<OrderDto> findByOrderStatus(Status status);




}
