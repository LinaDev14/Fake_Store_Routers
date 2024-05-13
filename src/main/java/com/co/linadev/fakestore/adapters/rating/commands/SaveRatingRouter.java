package com.co.linadev.fakestore.adapters.rating.commands;


import com.co.linadev.fakestore.application.service.rating.implementations.CreateRatingUseCase;
import com.co.linadev.fakestore.domain.dto.RatingDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class SaveRatingRouter {

    @Bean
    public RouterFunction<ServerResponse> saveRatingRouterFunction(CreateRatingUseCase createRatingUseCase){
        return route(
                POST("/api/save-rating")
                        .and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(RatingDto.class)
                        .flatMap(createRatingUseCase::saveRating)
                        .flatMap(result -> ServerResponse.ok()
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(result))
        );
    }
}
