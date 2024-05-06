package com.co.linadev.fakestore.application.usecases.order;

import reactor.core.publisher.Mono;

public interface GenerateReport {

    // generate report pdf
    Mono<Void> generateOrderReport(String fileName);
}
