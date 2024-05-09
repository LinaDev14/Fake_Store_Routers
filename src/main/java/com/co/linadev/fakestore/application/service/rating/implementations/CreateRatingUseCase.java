package com.co.linadev.fakestore.application.service.rating.implementations;

import com.co.linadev.fakestore.application.mappers.RatingMapper;
import com.co.linadev.fakestore.application.service.rating.interfaces.CreateRating;
import com.co.linadev.fakestore.domain.dto.RatingDto;
import com.co.linadev.fakestore.domain.repository.RatingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CreateRatingUseCase implements CreateRating {

    private final RatingRepository ratingRepository;
    private final RatingMapper ratingMapper;

    @Override
    public Mono<RatingDto> saveRating(RatingDto ratingDto) {
        return ratingRepository.save(ratingMapper.mapToCollectionRating()
                        .apply(ratingDto))
                .map(ratingMapper.mapToDtoRating());
    }
}
