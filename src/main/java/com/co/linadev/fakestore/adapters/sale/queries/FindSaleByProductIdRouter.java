package com.co.linadev.fakestore.adapters.sale.queries;

import com.co.linadev.fakestore.application.service.sale.implementations.FindSalesByProductIdUseCase;
import com.co.linadev.fakestore.domain.dto.SaleDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class FindSaleByProductIdRouter {

    @Bean
    public RouterFunction<ServerResponse> findSaleByProductIdRouterFunction(FindSalesByProductIdUseCase findSalesByProductIdUseCase){
        return route(GET("api/sale/product/{productId}"),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(findSalesByProductIdUseCase
                                .findSalesByProductId(request.pathVariable("productId")), SaleDto.class)
                        )
        );
    }
}
