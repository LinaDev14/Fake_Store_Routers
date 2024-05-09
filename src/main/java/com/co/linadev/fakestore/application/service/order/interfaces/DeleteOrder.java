package com.co.linadev.fakestore.application.service.order.interfaces;

import reactor.core.publisher.Mono;

public interface DeleteOrder {

    Mono<String> deleteOrder(String id);
}
