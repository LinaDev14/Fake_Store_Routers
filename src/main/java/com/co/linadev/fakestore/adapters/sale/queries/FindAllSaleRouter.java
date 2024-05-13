package com.co.linadev.fakestore.adapters.sale.queries;

import com.co.linadev.fakestore.application.service.sale.implementations.FindAllSaleUseCase;
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
public class FindAllSaleRouter {

    @Bean
    public RouterFunction<ServerResponse> findAllSalesRouterFunction(FindAllSaleUseCase findAllSaleUseCase){
        return route(
                GET("/api/sales"),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(findAllSaleUseCase.findAllSales(), SaleDto.class)));
    }
}
