package com.co.linadev.fakestore.application.service.rating.interfaces;

import com.co.linadev.fakestore.domain.dto.RatingDto;
import reactor.core.publisher.Mono;

public interface CreateRating {

    Mono<RatingDto> saveRating(RatingDto ratingDto);
}
