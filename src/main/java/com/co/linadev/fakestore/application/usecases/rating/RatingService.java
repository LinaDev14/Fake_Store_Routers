package com.co.linadev.fakestore.application.usecases.rating;


import com.co.linadev.fakestore.application.mappers.RatingMapper;
import com.co.linadev.fakestore.domain.dto.RatingDto;
import com.co.linadev.fakestore.domain.repository.RatingRepository;
import com.co.linadev.fakestore.domain.utils.messages.RatingMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RatingService implements RatingServiceInterface {

    private final RatingRepository ratingRepository;
    private final RatingMapper ratingMapper;

    @Override
    public Mono<RatingDto> findByRatingId(String id) {
        return ratingRepository.findById(id)
                .map(ratingMapper.mapToDtoRating())
                .switchIfEmpty(Mono.error(new RuntimeException(RatingMessage.RATING_NOT_FOUND)));
    }

    @Override
    public Flux<RatingDto> findAllRatings() {
        return ratingRepository.findAll()
                .map(ratingMapper.mapToDtoRating());
    }

    @Override
    public Mono<RatingDto> saveRating(RatingDto ratingDto) {
        return ratingRepository.save(ratingMapper.mapToCollectionRating()
                .apply(ratingDto))
                .map(ratingMapper.mapToDtoRating());
    }

    @Override
    public Flux<RatingDto> fillRating(List<RatingDto> ratingDto) {
        return ratingRepository.saveAll(ratingDto.stream()
                .map(ratingMapper.mapToCollectionRating())
                .collect(Collectors.toList()))
                .map(ratingMapper.mapToDtoRating());
    }
}
