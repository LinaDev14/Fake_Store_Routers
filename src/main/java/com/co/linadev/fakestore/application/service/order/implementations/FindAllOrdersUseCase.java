package com.co.linadev.fakestore.application.service.order.implementations;

import com.co.linadev.fakestore.application.mappers.OrderMapper;
import com.co.linadev.fakestore.application.service.order.interfaces.FindAllOrders;
import com.co.linadev.fakestore.domain.dto.OrderDto;
import com.co.linadev.fakestore.domain.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
@Service
public class FindAllOrdersUseCase implements FindAllOrders {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    @Override
    public Flux<OrderDto> listOrders() {
        return orderRepository.findAll()
                .map(orderMapper.mapToDtoOder());
    }
}
