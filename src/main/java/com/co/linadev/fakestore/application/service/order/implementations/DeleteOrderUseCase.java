package com.co.linadev.fakestore.application.service.order.implementations;

import com.co.linadev.fakestore.application.service.order.interfaces.DeleteOrder;
import com.co.linadev.fakestore.domain.repository.OrderRepository;
import com.co.linadev.fakestore.domain.utils.messages.OrderMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class DeleteOrderUseCase implements DeleteOrder {

    private final OrderRepository orderRepository;


    @Override
    public Mono<String> deleteOrder(String id) {
        return orderRepository.deleteById(id)
                .flatMap(order -> orderRepository.deleteById(id))
                .then(Mono.just(OrderMessage.ORDER_DELETE));
    }
}
