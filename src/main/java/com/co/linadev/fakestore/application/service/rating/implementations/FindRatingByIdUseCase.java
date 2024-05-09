package com.co.linadev.fakestore.application.service.rating.implementations;

import com.co.linadev.fakestore.application.mappers.RatingMapper;
import com.co.linadev.fakestore.application.service.rating.interfaces.FindRatingById;
import com.co.linadev.fakestore.domain.dto.RatingDto;
import com.co.linadev.fakestore.domain.repository.RatingRepository;
import com.co.linadev.fakestore.domain.utils.messages.RatingMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class FindRatingByIdUseCase implements FindRatingById {

    private final RatingRepository ratingRepository;
    private final RatingMapper ratingMapper;


    @Override
    public Mono<RatingDto> findByRatingId(String id) {
        return ratingRepository.findById(id)
                .map(ratingMapper.mapToDtoRating())
                .switchIfEmpty(Mono.error(new RuntimeException(RatingMessage.RATING_NOT_FOUND)));
    }
}
