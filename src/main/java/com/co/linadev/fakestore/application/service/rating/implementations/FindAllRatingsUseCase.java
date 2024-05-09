package com.co.linadev.fakestore.application.service.rating.implementations;

import com.co.linadev.fakestore.application.mappers.RatingMapper;
import com.co.linadev.fakestore.application.service.rating.interfaces.FindAllRatings;
import com.co.linadev.fakestore.domain.dto.RatingDto;
import com.co.linadev.fakestore.domain.repository.RatingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class FindAllRatingsUseCase implements FindAllRatings {

    private final RatingRepository ratingRepository;
    private final RatingMapper ratingMapper;


    @Override
    public Flux<RatingDto> findAllRatings() {
        return ratingRepository.findAll()
                .map(ratingMapper.mapToDtoRating());
    }
}
