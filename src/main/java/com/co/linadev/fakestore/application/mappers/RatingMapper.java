package com.co.linadev.fakestore.application.mappers;

import com.co.linadev.fakestore.domain.collections.Rating;
import com.co.linadev.fakestore.domain.dto.RatingDto;

import java.util.function.Function;

public class RatingMapper {

    public Function<Rating, RatingDto> mapToDtoRating(){

        return rating -> new RatingDto(
              rating.getId(),
              rating.getUserId(),
              rating.getProductId(),
              rating.getComment(),
              rating.getRating()
        );
    }

    public Function<RatingDto, Rating> mapToCollectionRating(){

        return ratingDto -> new Rating(
                ratingDto.getId(),
                ratingDto.getUserId(),
                ratingDto.getProductId(),
                ratingDto.getComment(),
                ratingDto.getRating()
        );
    }
}
