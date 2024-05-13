package com.co.linadev.fakestore.adapters.payment.commands;

import com.co.linadev.fakestore.application.service.payment.implementations.CreateMethodPaymentUseCase;
import com.co.linadev.fakestore.domain.dto.PaymentDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class SavePaymentMethodRouter {

    @Bean
    public RouterFunction<ServerResponse> savePaymentRouterFunction(CreateMethodPaymentUseCase createMethodPaymentUseCase){
        return route(
                POST("/api/save-payment")
                        .and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(PaymentDto.class)
                        .flatMap(createMethodPaymentUseCase::saveMethodPayment)
                        .flatMap(result -> ServerResponse.ok()
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(result))
        );
    }
}
