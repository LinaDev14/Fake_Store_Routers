package com.co.linadev.fakestore.adapters.order.commands;

import com.co.linadev.fakestore.application.service.order.implementations.DeleteOrderUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.DELETE;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class DeleteOrderRouter {

    @Bean
    public RouterFunction<ServerResponse> deleteOrderRouterFunction(DeleteOrderUseCase deleteOrderUseCase){
        return route(
                DELETE("/api/delete-order/{id}"),
                request -> ServerResponse.ok()
                        .body(BodyInserters.fromPublisher(deleteOrderUseCase.deleteOrder((
                                request.pathVariable("id"))),
                                String.class)));
    }
}
