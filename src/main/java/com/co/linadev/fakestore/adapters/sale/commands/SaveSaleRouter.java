package com.co.linadev.fakestore.adapters.sale.commands;

import com.co.linadev.fakestore.application.service.sale.implementations.CreateSaleUseCase;
import com.co.linadev.fakestore.domain.dto.SaleDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class SaveSaleRouter {

    @Bean
    public RouterFunction<ServerResponse> saveSaleRouterFunction(CreateSaleUseCase createSaleUseCase){
        return route(
                POST("/api/save-sale")
                        .and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(SaleDto.class)
                        .flatMap(createSaleUseCase::saveSale)
                        .flatMap(result -> ServerResponse.ok()
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(result))
        );
    }
}
