package com.co.linadev.fakestore.adapters.consultant.commands;

import com.co.linadev.fakestore.application.service.consultant.implementations.CreateConsultantUseCase;
import com.co.linadev.fakestore.domain.dto.ConsultantDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class SaveConsultantRouter {

    @Bean
    public RouterFunction<ServerResponse> saveConsultantRouterFunction(CreateConsultantUseCase createConsultantUseCase){
        return route(
                POST("/api/save-consultant")
                        .and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(ConsultantDto.class)
                        .flatMap(createConsultantUseCase::createConsultant)
                        .flatMap(result -> ServerResponse.ok()
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(result))
        );
    }
}
