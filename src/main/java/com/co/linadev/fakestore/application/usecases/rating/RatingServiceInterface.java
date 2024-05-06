package com.co.linadev.fakestore.application.usecases.rating;

import com.co.linadev.fakestore.domain.dto.RatingDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface RatingServiceInterface {

    // find by id
    Mono<RatingDto> findByRatingId(String id);

    // find all ratings
    Flux<RatingDto> findAllRatings();

    // save ratings
    Mono<RatingDto> saveRating(RatingDto ratingDto);

    // fill data
    Flux<RatingDto> fillRating (List<RatingDto> ratingDto);
}
