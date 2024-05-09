package com.co.linadev.fakestore.application.service.order.implementations;


import com.co.linadev.fakestore.application.mappers.OrderMapper;
import com.co.linadev.fakestore.application.service.order.interfaces.UpdateOrder;
import com.co.linadev.fakestore.domain.dto.OrderDto;
import com.co.linadev.fakestore.domain.repository.OrderRepository;
import com.co.linadev.fakestore.domain.utils.messages.OrderMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Objects;

@RequiredArgsConstructor
@Service
public class UpdateOrderUseCase implements UpdateOrder {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;


    @Override
    public Mono<OrderDto> updateOrder(OrderDto orderDto) {
        Objects.requireNonNull(orderDto.getId(), OrderMessage.REQUIRED);

        return orderRepository.save(orderMapper.mapToCollectionOrder()
                        .apply(orderDto))
                .map(orderMapper.mapToDtoOder());
    }
}
