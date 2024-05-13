package com.co.linadev.fakestore.adapters.product.queries;

import com.co.linadev.fakestore.application.service.product.implementations.FindAllProductsByPriceUseCase;
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
public class FindAllByPriceRouter {

    @Bean
    public RouterFunction<ServerResponse> findProductByPriceRouterFunction(FindAllProductsByPriceUseCase findAllByPriceUseCase){
        return route(
                GET("api/products/price/{price}"),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(findAllByPriceUseCase
                                .findAllByPrice(Double.valueOf(request.pathVariable("price"))), ProductDto.class))
        );
    }
}
