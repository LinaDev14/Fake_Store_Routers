package com.co.linadev.fakestore.application.usecases.order;

import com.co.linadev.fakestore.application.mappers.OrderMapper;
import com.co.linadev.fakestore.domain.dto.OrderDto;
import com.co.linadev.fakestore.domain.repository.OrderRepository;
import com.co.linadev.fakestore.domain.utils.messages.OrderMessage;
import com.co.linadev.fakestore.domain.utils.valueObjects.Status;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService implements OrderServiceInterface {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;


    @Override
    public Flux<OrderDto> listOrders() {
        return orderRepository.findAll()
                .map(orderMapper.mapToDtoOder());
    }

    @Override
    public Mono<OrderDto> findByOrderId(String id) {
        return orderRepository.findById(id)
                .map(orderMapper.mapToDtoOder())
                .switchIfEmpty(Mono.error(new RuntimeException(OrderMessage.NO_ORDER)));
    }

    @Override
    public Mono<OrderDto> saveOrder(OrderDto orderDto) {
        return orderRepository.save(orderMapper.mapToCollectionOrder()
                .apply(orderDto))
                .map(orderMapper.mapToDtoOder());
    }

    @Override
    public Mono<OrderDto> updateOrder(OrderDto orderDto) {

        Objects.requireNonNull(orderDto.getId(), OrderMessage.REQUIRED);

        return orderRepository.save(orderMapper.mapToCollectionOrder()
                .apply(orderDto))
                .map(orderMapper.mapToDtoOder());
    }

    @Override
    public Mono<String> deleteOrder(String id) {
        return orderRepository.deleteById(id)
                .flatMap(order -> orderRepository.deleteById(id))
                .then(Mono.just(OrderMessage.ORDER_DELETE));
    }

    @Override
    public Flux<OrderDto> saveAllData(List<OrderDto> orders) {
        return orderRepository.saveAll(orders.stream()
                .map(orderMapper.mapToCollectionOrder())
                .collect(Collectors.toList()))
                .map(orderMapper.mapToDtoOder());
    }

    @Override
    public Flux<OrderDto> findByOrderStatus(Status status) {
        return orderRepository.findByOrderStatus(status)
                .map(orderMapper.mapToDtoOder());
    }
}
