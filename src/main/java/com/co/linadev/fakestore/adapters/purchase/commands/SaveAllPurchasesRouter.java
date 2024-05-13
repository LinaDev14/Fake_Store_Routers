package com.co.linadev.fakestore.adapters.purchase.commands;


import com.co.linadev.fakestore.application.service.purchase.implementations.SaveAllPurchasesUseCase;
import com.co.linadev.fakestore.domain.dto.PurchaseDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class SaveAllPurchasesRouter {

    @Bean
    public RouterFunction<ServerResponse> saveAllPurchasesRouterFunction(SaveAllPurchasesUseCase saveAllPurchasesUseCase){
        return route(
                POST("/api/save-all-purchases")
                        .and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(new ParameterizedTypeReference<List<PurchaseDto>>() {})
                        .flatMapMany(saveAllPurchasesUseCase::saveAllPurchase)
                        .collect(Collectors.toList())
                        .flatMap(response -> ServerResponse.ok()
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(response))

        );
    }
}
