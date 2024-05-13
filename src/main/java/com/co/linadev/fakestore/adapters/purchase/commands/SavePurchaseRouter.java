package com.co.linadev.fakestore.adapters.purchase.commands;

import com.co.linadev.fakestore.application.service.purchase.implementations.CreatePurchaseUseCase;
import com.co.linadev.fakestore.domain.dto.PurchaseDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class SavePurchaseRouter {

    @Bean
    public RouterFunction<ServerResponse> savePurchaseRouterFunction(CreatePurchaseUseCase createPurchaseUseCase){
        return route(
                POST("/api/save-purchase")
                        .and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(PurchaseDto.class)
                        .flatMap(createPurchaseUseCase::savePurchase)
                        .flatMap(result -> ServerResponse.ok()
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(result))
        );
    }
}
