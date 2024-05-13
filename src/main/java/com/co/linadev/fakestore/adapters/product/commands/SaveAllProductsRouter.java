package com.co.linadev.fakestore.adapters.product.commands;


import com.co.linadev.fakestore.application.service.product.implementations.SaveAllProductsUseCase;
import com.co.linadev.fakestore.domain.dto.ProductDto;
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
public class SaveAllProductsRouter {

    @Bean
    public RouterFunction<ServerResponse> saveAllProductsRouterFunction(SaveAllProductsUseCase saveAllProductsUseCase){
        return route(
                POST("/api/save-all-products")
                        .and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(new ParameterizedTypeReference<List<ProductDto>>() {})
                        .flatMapMany(saveAllProductsUseCase::fillData)
                        .collect(Collectors.toList())
                        .flatMap(response -> ServerResponse.ok()
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(response))

        );
    }
}
