package com.co.linadev.fakestore.adapters.shipping.queries;

import com.co.linadev.fakestore.application.service.shipping.implementations.FindShipmentsByStatusUseCase;
import com.co.linadev.fakestore.domain.dto.ShippingDto;
import com.co.linadev.fakestore.domain.utils.valueObjects.Status;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class FindShipmentsByStatusRouter {

    @Bean
    public RouterFunction<ServerResponse> findShipmentsByStatusRouterFunction(FindShipmentsByStatusUseCase findShipmentsByStatusUseCase){
        return route(GET(
                        "api/shipments/status/{status}"),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(findShipmentsByStatusUseCase.findShipmentsByStatus(
                                        Status.valueOf(request.pathVariable("status"))),
                                ShippingDto.class)));
    }
}
