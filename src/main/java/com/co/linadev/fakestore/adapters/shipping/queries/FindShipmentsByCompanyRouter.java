package com.co.linadev.fakestore.adapters.shipping.queries;

import com.co.linadev.fakestore.application.service.shipping.implementations.FindShipmentsByCompanyUseCase;
import com.co.linadev.fakestore.domain.dto.ShippingDto;
import com.co.linadev.fakestore.domain.utils.valueObjects.ShippingCompany;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class FindShipmentsByCompanyRouter {

    @Bean
    public RouterFunction<ServerResponse> findShipmentsByCompanyRouterFunction(FindShipmentsByCompanyUseCase shipmentsByCompanyUseCase){
        return route(GET(
                        "api/shipments/shippingCompany/{company}"),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(shipmentsByCompanyUseCase.findShipmentsByCompany(
                                        ShippingCompany.valueOf(request.pathVariable("company"))),
                                ShippingDto.class)));
    }
}
