package com.co.linadev.fakestore.adapters.purchase.queries;


import com.co.linadev.fakestore.application.service.purchase.implementations.FindPurchasesByStatusUseCase;
import com.co.linadev.fakestore.domain.dto.PurchaseDto;
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
public class FindPurchaseByStatusRouter {

    @Bean
    public RouterFunction<ServerResponse> findOrderByStatusRouterFunction(FindPurchasesByStatusUseCase findPurchasesByStatusUseCase){
        return route(GET(
                        "api/purchase/status/{status}"),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(findPurchasesByStatusUseCase.findPurchaseByStatus(
                                        Status.valueOf(request.pathVariable("status"))),
                                PurchaseDto.class)));
    }
}
