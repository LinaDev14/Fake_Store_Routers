package com.co.linadev.fakestore.adapters.shipping.commands;

import com.co.linadev.fakestore.application.service.shipping.implementations.FillDataShipmentsUseCase;
import com.co.linadev.fakestore.domain.dto.ShippingDto;
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
public class SaveAllShipmentsRouter {

    @Bean
    public RouterFunction<ServerResponse> saveAllShipmentsRouterFunction(FillDataShipmentsUseCase fillDataShipmentsUseCase){
        return route(
                POST("/api/save-all-shipments")
                        .and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(new ParameterizedTypeReference<List<ShippingDto>>() {})
                        .flatMapMany(fillDataShipmentsUseCase::fillDataShipments)
                        .collect(Collectors.toList())
                        .flatMap(response -> ServerResponse.ok()
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(response))

        );
    }
}
