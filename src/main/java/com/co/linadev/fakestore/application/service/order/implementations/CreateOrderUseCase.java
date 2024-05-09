package com.co.linadev.fakestore.application.service.order.implementations;

import com.co.linadev.fakestore.application.mappers.OrderMapper;
import com.co.linadev.fakestore.application.service.order.interfaces.CreateOrder;
import com.co.linadev.fakestore.domain.dto.OrderDto;
import com.co.linadev.fakestore.domain.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class CreateOrderUseCase implements CreateOrder {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;


    @Override
    public Mono<OrderDto> saveOrder(OrderDto orderDto) {
        return orderRepository.save(orderMapper.mapToCollectionOrder()
                        .apply(orderDto))
                .map(orderMapper.mapToDtoOder());
    }
}
