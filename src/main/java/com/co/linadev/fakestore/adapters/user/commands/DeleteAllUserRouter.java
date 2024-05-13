package com.co.linadev.fakestore.adapters.user.commands;

import com.co.linadev.fakestore.application.service.user.implementations.DeleteAllUserUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.DELETE;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class DeleteAllUserRouter {

    @Bean
    public RouterFunction<ServerResponse> DeleteAllUsersRouterFunction(DeleteAllUserUseCase deleteAllUserUseCase){
        return route(
                DELETE("/api/delete-all-users"),
                request -> ServerResponse.ok()
                        .body(BodyInserters.fromPublisher(deleteAllUserUseCase.deleteAll(),String.class))
        );
    }
}
