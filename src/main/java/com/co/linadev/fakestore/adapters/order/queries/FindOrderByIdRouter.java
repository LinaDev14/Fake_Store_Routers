package com.co.linadev.fakestore.adapters.order.queries;

import com.co.linadev.fakestore.application.service.order.implementations.FindOrderByIdUseCase;
import com.co.linadev.fakestore.domain.dto.OrderDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class FindOrderByIdRouter {

    @Bean
    public RouterFunction<ServerResponse> findOrderByIdRouterFunction(FindOrderByIdUseCase findOrderByIdUseCase){
        return route(GET("/api/order/{id}"),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(findOrderByIdUseCase
                                .findByOrderId(request.pathVariable("id")), OrderDto.class)
                        )
        );
    }
}
