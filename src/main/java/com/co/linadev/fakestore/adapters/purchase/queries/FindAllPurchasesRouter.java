package com.co.linadev.fakestore.adapters.purchase.queries;

import com.co.linadev.fakestore.application.service.purchase.implementations.FindAllPurchasesUseCase;
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
public class FindAllPurchasesRouter {

    @Bean
    public RouterFunction<ServerResponse> findAllPurchasesRouterFunction(FindAllPurchasesUseCase findAllPurchasesUseCase){
        return route(
                GET("/api/purchases"),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(findAllPurchasesUseCase.listPurchases(), PurchaseDto.class)));
    }
}
