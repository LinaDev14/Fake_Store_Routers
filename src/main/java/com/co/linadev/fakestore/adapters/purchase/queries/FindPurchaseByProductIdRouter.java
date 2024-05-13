package com.co.linadev.fakestore.adapters.purchase.queries;


import com.co.linadev.fakestore.application.service.purchase.implementations.FindPurchasesByProductIdUseCase;
import com.co.linadev.fakestore.domain.dto.PurchaseDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class FindPurchaseByProductIdRouter {

    @Bean
    public RouterFunction<ServerResponse> findPurchaseByProductIdRouterFunction(FindPurchasesByProductIdUseCase findPurchasesByProductIdUseCase){
        return route(GET("api/purchase/product/{productId}"),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(findPurchasesByProductIdUseCase
                                .findPurchasesByProductId(request.pathVariable("productId")), PurchaseDto.class)
                        )
        );
    }
}
