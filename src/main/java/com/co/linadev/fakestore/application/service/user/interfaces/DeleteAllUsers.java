package com.co.linadev.fakestore.application.service.user.interfaces;

import reactor.core.publisher.Mono;

public interface DeleteAllUsers {

    Mono<String> deleteAll();
}
