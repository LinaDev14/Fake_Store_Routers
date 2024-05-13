package com.co.linadev.fakestore.adapters.consultant.queries;

import com.co.linadev.fakestore.application.service.consultant.implementations.FindConsultantByIdUseCase;
import com.co.linadev.fakestore.domain.dto.ConsultantDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class FindConsultantByIdRouter {

    @Bean
    public RouterFunction<ServerResponse> findConsultantByIdRouterFunction(FindConsultantByIdUseCase findConsultantById){
        return route(GET("api/consultant/{id}"),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(findConsultantById
                                .findConsultantById(request.pathVariable("id")), ConsultantDto.class)
                        )
        );
    }
}
