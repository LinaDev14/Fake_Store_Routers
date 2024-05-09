package com.co.linadev.fakestore.application.service.sale.interfaces;

import reactor.core.publisher.Mono;

public interface DeleteSale {

    Mono<String> deleteSale(String id);
}
