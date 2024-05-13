package com.co.linadev.fakestore.adapters.purchase.queries;

import com.co.linadev.fakestore.application.service.purchase.implementations.FindPurchasesByUserIdUseCase;
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
public class FindPurchaseByUserIdRouter {

    @Bean
    public RouterFunction<ServerResponse> findPurchaseByUserIdRouterFunction(FindPurchasesByUserIdUseCase findPurchasesByUserIdUseCase){
        return route(GET("api/purchase/user/{userId}"),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(findPurchasesByUserIdUseCase
                                .findPurchasesByUserId(request.pathVariable("userId")), PurchaseDto.class)
                        )
        );
    }
}
