package com.co.linadev.fakestore.adapters.product.commands;

import com.co.linadev.fakestore.application.service.product.implementations.CreateProductUseCase;
import com.co.linadev.fakestore.domain.dto.ProductDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class SaveProductRouter {

    @Bean
    public RouterFunction<ServerResponse> saveProductRouterFunction(CreateProductUseCase createProductUseCase){
        return route(
                POST("/api/save-product")
                        .and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(ProductDto.class)
                        .flatMap(createProductUseCase::saveProduct)
                        .flatMap(result -> ServerResponse.ok()
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(result))
        );
    }
}
