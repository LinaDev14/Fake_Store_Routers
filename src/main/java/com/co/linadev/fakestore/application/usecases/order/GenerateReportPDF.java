package com.co.linadev.fakestore.application.usecases.order;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class GenerateReportPDF implements GenerateReport {


    @Override
    public Mono<Void> generateOrderReport(String fileName) {
        return null;
    }
}
