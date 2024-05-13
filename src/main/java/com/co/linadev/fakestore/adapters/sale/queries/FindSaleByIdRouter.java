package com.co.linadev.fakestore.adapters.sale.queries;

import com.co.linadev.fakestore.application.service.sale.implementations.FindSaleByIdUseCase;
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
public class FindSaleByIdRouter {

    @Bean
    public RouterFunction<ServerResponse> findSaleByIdRouterFunction(FindSaleByIdUseCase findSaleByIdUseCase){
        return route(GET("api/sale/{id}"),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(findSaleByIdUseCase
                                .findById(request.pathVariable("id")), SaleDto.class)
                        )
        );
    }
}
