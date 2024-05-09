package com.co.linadev.fakestore.application.service.order.implementations;

import com.co.linadev.fakestore.application.mappers.OrderMapper;
import com.co.linadev.fakestore.application.service.order.interfaces.FindOrderById;
import com.co.linadev.fakestore.domain.dto.OrderDto;
import com.co.linadev.fakestore.domain.repository.OrderRepository;
import com.co.linadev.fakestore.domain.utils.messages.OrderMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class FindOrderByIdUseCase implements FindOrderById {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;


    @Override
    public Mono<OrderDto> findByOrderId(String id) {
        return orderRepository.findById(id)
                .map(orderMapper.mapToDtoOder())
                .switchIfEmpty(Mono.error(new RuntimeException(OrderMessage.NO_ORDER)));
    }
}
