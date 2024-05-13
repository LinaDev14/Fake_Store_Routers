package com.co.linadev.fakestore.adapters.order.queries;

import com.co.linadev.fakestore.application.service.order.implementations.FindOrderByStatusUseCase;
import com.co.linadev.fakestore.domain.dto.OrderDto;
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
public class FindOrderByStatusRouter {

    @Bean
    public RouterFunction<ServerResponse> findOrderByStatusRouterFunction(FindOrderByStatusUseCase findOrderByStatusUseCase){
        return route(GET(
                "/api/order/status/{status}"),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(findOrderByStatusUseCase.findByOrderStatus(
                                Status.valueOf(request.pathVariable("status"))),
                                OrderDto.class)));
    }

}
