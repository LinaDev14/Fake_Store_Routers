package com.co.linadev.fakestore.adapters.shipping.queries;

import com.co.linadev.fakestore.application.service.shipping.implementations.FindShippingByOrderUseCase;
import com.co.linadev.fakestore.domain.dto.ShippingDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class FindShippingByOrderRouter {

    @Bean
    public RouterFunction<ServerResponse> findShippingByOrderIdRouterFunction(FindShippingByOrderUseCase findShippingByOrderUseCase){
        return route(GET("api/shipping/order/{orderId}"),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(findShippingByOrderUseCase
                                .findShippingByOrderId(request.pathVariable("userId")), ShippingDto.class)
                        )
        );
    }
}
