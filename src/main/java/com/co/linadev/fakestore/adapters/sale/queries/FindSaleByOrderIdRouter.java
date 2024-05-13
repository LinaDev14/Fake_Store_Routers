package com.co.linadev.fakestore.adapters.sale.queries;

import com.co.linadev.fakestore.application.service.sale.implementations.FindSaleByOrderIdUseCase;
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
public class FindSaleByOrderIdRouter {

    @Bean
    public RouterFunction<ServerResponse> findSaleByOrderIdRouterFunction(FindSaleByOrderIdUseCase findSaleByOrderIdUseCase){
        return route(GET("api/sale/order/{orderId}"),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(findSaleByOrderIdUseCase
                                .findSalesByOrderId(request.pathVariable("orderId")), SaleDto.class)
                        )
        );
    }
}
