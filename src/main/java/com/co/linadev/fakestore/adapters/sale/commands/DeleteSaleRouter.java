package com.co.linadev.fakestore.adapters.sale.commands;

import com.co.linadev.fakestore.application.service.sale.implementations.DeleteSaleUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.DELETE;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class DeleteSaleRouter {

    @Bean
    public RouterFunction<ServerResponse> deleteSaleRouterFunction(DeleteSaleUseCase deleteSaleUseCase){
        return route(
                DELETE("/api/delete-sale/{id}"),
                request -> ServerResponse.ok()
                        .body(BodyInserters.fromPublisher(deleteSaleUseCase.deleteSale((
                                        request.pathVariable("id"))),
                                String.class)));
    }
}
