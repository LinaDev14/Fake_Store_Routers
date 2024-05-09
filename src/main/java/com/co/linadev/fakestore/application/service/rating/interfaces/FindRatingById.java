package com.co.linadev.fakestore.application.service.rating.interfaces;

import com.co.linadev.fakestore.domain.dto.RatingDto;
import reactor.core.publisher.Mono;

public interface FindRatingById {

    Mono<RatingDto> findByRatingId(String id);
}
