package com.co.linadev.fakestore.adapters.consultant.commands;


import com.co.linadev.fakestore.application.service.consultant.implementations.DeleteConsultantUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.DELETE;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class DeleteConsultantRouter {

    @Bean
    public RouterFunction<ServerResponse> deleteConsultantRouterFunction(DeleteConsultantUseCase deleteConsultantUseCase){
        return route(
                DELETE("/api/delete-consultant/{id}"),
                request -> ServerResponse.ok()
                        .body(BodyInserters.fromPublisher(deleteConsultantUseCase.deleteConsultant((request.pathVariable("id"))),
                                String.class)));
    }
}
