package com.co.linadev.fakestore.adapters.rating.queries;

import com.co.linadev.fakestore.application.service.rating.implementations.FindRatingByIdUseCase;
import com.co.linadev.fakestore.domain.dto.RatingDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class FindRatingByIdRouter {

    @Bean
    public RouterFunction<ServerResponse> findRatingByIdRouterFunction(FindRatingByIdUseCase findRatingByIdUseCase){
        return route(GET("api/rating/{id}"),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(findRatingByIdUseCase
                                .findByRatingId(request.pathVariable("id")), RatingDto.class)
                        )
        );
    }
}
