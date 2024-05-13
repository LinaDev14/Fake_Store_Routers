package com.co.linadev.fakestore.adapters.payment.queries;

import com.co.linadev.fakestore.application.service.payment.implementations.FindAllMethodsUseCase;
import com.co.linadev.fakestore.domain.dto.PaymentDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;


@Configuration
public class FindAllPaymentsMethodsRouter {

    @Bean
    public RouterFunction<ServerResponse> findAllPaymentsRouterFunction(FindAllMethodsUseCase findAllMethodsUseCase){
        return route(
                GET("/api/methodsPayment"),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(findAllMethodsUseCase.findAllPaymentMethods(), PaymentDto.class)));
    }
}
