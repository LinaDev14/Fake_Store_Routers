package com.co.linadev.fakestore.adapters.shipping.commands;

import com.co.linadev.fakestore.application.service.shipping.implementations.UpdateShippingUseCase;
import com.co.linadev.fakestore.domain.dto.ShippingDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.PUT;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class UpdateShippingRouter {

    @Bean
    public RouterFunction<ServerResponse> updateShippingRouterFunction(UpdateShippingUseCase updateShippingUseCase){

        return route(PUT("/api/update_shipping")
                        .and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(ShippingDto.class)
                        .flatMap(updateShippingUseCase::updateShipping)
                        .flatMap(result -> ServerResponse.ok()
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(result)
                        )
        );
    }
}
