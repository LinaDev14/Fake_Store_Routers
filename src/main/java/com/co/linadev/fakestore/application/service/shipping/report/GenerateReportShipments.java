package com.co.linadev.fakestore.application.service.shipping.report;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class GenerateReportShipments implements GenerateReport {

    @Override
    public Mono<Void> generateShippingReport(String fileName) {
        return null;
    }
}
