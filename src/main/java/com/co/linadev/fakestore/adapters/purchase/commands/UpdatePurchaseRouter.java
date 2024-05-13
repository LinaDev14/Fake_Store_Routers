package com.co.linadev.fakestore.adapters.purchase.commands;

import com.co.linadev.fakestore.application.service.purchase.implementations.UpdatePurchaseUseCase;
import com.co.linadev.fakestore.domain.dto.PurchaseDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.PUT;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class UpdatePurchaseRouter {

    @Bean
    public RouterFunction<ServerResponse> updatePurchaseRouterFunction(UpdatePurchaseUseCase updatePurchaseUseCase){

        return route(PUT("/api/update_purchase")
                        .and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(PurchaseDto.class)
                        .flatMap(updatePurchaseUseCase::updatePurchase)
                        .flatMap(result -> ServerResponse.ok()
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(result)
                        )
        );
    }
}
