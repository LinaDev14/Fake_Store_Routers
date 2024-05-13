package com.co.linadev.fakestore.adapters.order.commands;

import com.co.linadev.fakestore.application.service.order.implementations.CreateOrderUseCase;
import com.co.linadev.fakestore.domain.dto.OrderDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class SaveOrderRouter {

    @Bean
    public RouterFunction<ServerResponse> saveOrderRouterFunction(CreateOrderUseCase createOrderUseCase){
        return route(
                POST("/api/save-order")
                        .and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(OrderDto.class)
                        .flatMap(createOrderUseCase::saveOrder)
                        .flatMap(result -> ServerResponse.ok()
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(result))
        );
    }
}
