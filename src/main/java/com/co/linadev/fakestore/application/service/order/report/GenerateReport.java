package com.co.linadev.fakestore.application.service.order.report;

import reactor.core.publisher.Mono;

public interface GenerateReport {

    // generate report pdf
    Mono<Void> generateOrderReport(String fileName);
}
