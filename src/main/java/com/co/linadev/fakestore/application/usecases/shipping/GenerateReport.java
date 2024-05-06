package com.co.linadev.fakestore.application.usecases.shipping;

import reactor.core.publisher.Mono;

public interface GenerateReport {
    // generate report
    Mono<Void> generateShippingReport(String fileName);
}
