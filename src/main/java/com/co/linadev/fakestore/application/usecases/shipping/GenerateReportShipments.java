package com.co.linadev.fakestore.application.usecases.shipping;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class GenerateReportShipments implements GenerateReport{

    @Override
    public Mono<Void> generateShippingReport(String fileName) {
        return null;
    }
}
