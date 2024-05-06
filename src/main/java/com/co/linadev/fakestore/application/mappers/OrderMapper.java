package com.co.linadev.fakestore.application.mappers;

import com.co.linadev.fakestore.domain.collections.Order;
import com.co.linadev.fakestore.domain.dto.OrderDto;

import java.util.function.Function;

public class OrderMapper {

    public Function<Order, OrderDto> mapToDtoOder(){

        return order -> new OrderDto(
                order.getId(),
                order.getUserId(),
                order.getProductId(),
                order.getPaymentId(),
                order.getQuantity(),
                order.getTotalOrder(),
                order.getStatus(),
                order.getStatusDescription(),
                order.getOrderDate()
        );
    }


    public Function<OrderDto, Order> mapToCollectionOrder(){

        return orderDto -> new Order(
            orderDto.getId(),
            orderDto.getUserId(),
            orderDto.getProductId(),
            orderDto.getPaymentId(),
            orderDto.getQuantity(),
            orderDto.getTotalOrder(),
            orderDto.getStatus(),
            orderDto.getStatusDescription(),
            orderDto.getOrderDate()
        );
    }
}
