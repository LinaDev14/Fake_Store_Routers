package com.co.linadev.fakestore.application.service.user.interfaces;

import reactor.core.publisher.Mono;

public interface DeleteUserById {

    Mono<String> deleteById(String id);
}
