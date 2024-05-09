package com.co.linadev.fakestore.application.service.shipping.report;

import reactor.core.publisher.Mono;

public interface GenerateReport {
    // generate report
    Mono<Void> generateShippingReport(String fileName);
}
