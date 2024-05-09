package com.co.linadev.fakestore.application.service.rating.interfaces;

import com.co.linadev.fakestore.domain.dto.RatingDto;
import reactor.core.publisher.Flux;

public interface FindAllRatings {

    Flux<RatingDto> findAllRatings();
}
