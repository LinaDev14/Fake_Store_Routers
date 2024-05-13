package com.co.linadev.fakestore.adapters.user.queries;

import com.co.linadev.fakestore.application.service.user.implementations.FindAllUserUseCase;
import com.co.linadev.fakestore.domain.dto.UserDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class FindAllUsersRouter {

    @Bean
    public RouterFunction<ServerResponse> findAllUsersRouterFunction(FindAllUserUseCase findAllUserUseCase){
        return route(
                GET("/api/users"),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(findAllUserUseCase.listUsers(), UserDto.class)));
    }
}
