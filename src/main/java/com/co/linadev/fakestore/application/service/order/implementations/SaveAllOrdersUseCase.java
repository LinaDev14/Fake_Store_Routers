package com.co.linadev.fakestore.application.service.order.implementations;


import com.co.linadev.fakestore.application.mappers.OrderMapper;
import com.co.linadev.fakestore.application.service.order.interfaces.SaveAllOrders;
import com.co.linadev.fakestore.domain.dto.OrderDto;
import com.co.linadev.fakestore.domain.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class SaveAllOrdersUseCase implements SaveAllOrders {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;


    @Override
    public Flux<OrderDto> saveAllData(List<OrderDto> orders) {
        return orderRepository.saveAll(orders.stream()
                        .map(orderMapper.mapToCollectionOrder())
                        .collect(Collectors.toList()))
                .map(orderMapper.mapToDtoOder());
    }
}
