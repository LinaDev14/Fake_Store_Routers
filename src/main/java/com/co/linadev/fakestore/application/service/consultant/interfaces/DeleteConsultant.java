package com.co.linadev.fakestore.application.service.consultant.interfaces;

import reactor.core.publisher.Mono;

public interface DeleteConsultant {

    Mono<String> deleteConsultant(String id);
}
