package com.co.linadev.fakestore.application.service.rating.interfaces;

import com.co.linadev.fakestore.domain.dto.RatingDto;
import reactor.core.publisher.Flux;

import java.util.List;

public interface FillDataRating {

    Flux<RatingDto> fillRating(List<RatingDto> ratingDto);
}
