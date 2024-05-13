package com.co.linadev.fakestore.adapters.product.queries;

import com.co.linadev.fakestore.application.service.product.implementations.FindAllProductsByNameUseCase;
import com.co.linadev.fakestore.domain.dto.ProductDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class FindAllProductsByNameRouter {

    @Bean
    public RouterFunction<ServerResponse> findProductByNameRouterFunction(FindAllProductsByNameUseCase findAllProductsByNameUseCase){
        return route(GET("api/products/name/{name}"),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(findAllProductsByNameUseCase
                                .findAllByProductName(request.pathVariable("name")), ProductDto.class)
                        )
        );
    }
}
