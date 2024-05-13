package com.co.linadev.fakestore.adapters.user.commands;

import com.co.linadev.fakestore.application.service.user.implementations.DeleteUserByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.DELETE;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class DeleteUserRouter {

    @Bean
    public RouterFunction<ServerResponse> deleteUserRouterFunction(DeleteUserByIdUseCase deleteUserByIdUseCase){
        return route(
                DELETE("/api/delete-user/{id}"),
                request -> ServerResponse.ok()
                        .body(BodyInserters.fromPublisher(deleteUserByIdUseCase.deleteById((
                                        request.pathVariable("id"))),
                                String.class)));
    }
}
