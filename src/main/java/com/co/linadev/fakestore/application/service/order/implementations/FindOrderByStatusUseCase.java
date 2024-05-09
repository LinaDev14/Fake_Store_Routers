package com.co.linadev.fakestore.application.service.order.implementations;

import com.co.linadev.fakestore.application.mappers.OrderMapper;
import com.co.linadev.fakestore.application.service.order.interfaces.FindByOrderStatus;
import com.co.linadev.fakestore.domain.dto.OrderDto;
import com.co.linadev.fakestore.domain.repository.OrderRepository;
import com.co.linadev.fakestore.domain.utils.valueObjects.Status;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
@Service
public class FindOrderByStatusUseCase implements FindByOrderStatus {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    @Override
    public Flux<OrderDto> findByOrderStatus(Status status) {
        return orderRepository.findOrdersByStatus(status)
                .map(orderMapper.mapToDtoOder());
    }
}
