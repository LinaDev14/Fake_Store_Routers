package com.co.linadev.fakestore.adapters.consultant.queries;

import com.co.linadev.fakestore.application.service.consultant.implementations.FindAllConsultantsUseCase;
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
public class FindAllConsultantsRouter {

    @Bean
    public RouterFunction<ServerResponse> findAllConsultantsRouterFunction(FindAllConsultantsUseCase findAllConsultantsUseCase){
        return route(
                GET("/api/consultants"),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(findAllConsultantsUseCase.listConsultants(), ConsultantDto.class)));
    }
}
