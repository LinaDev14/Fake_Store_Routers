package com.co.linadev.fakestore.application.service.rating.implementations;

import com.co.linadev.fakestore.application.mappers.RatingMapper;
import com.co.linadev.fakestore.application.service.rating.interfaces.FillDataRating;
import com.co.linadev.fakestore.domain.dto.RatingDto;
import com.co.linadev.fakestore.domain.repository.RatingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FillDataRatingUseCase implements FillDataRating {

    private final RatingRepository ratingRepository;
    private final RatingMapper ratingMapper;


    @Override
    public Flux<RatingDto> fillRating(List<RatingDto> ratingDto) {
        return ratingRepository.saveAll(ratingDto.stream()
                        .map(ratingMapper.mapToCollectionRating())
                        .collect(Collectors.toList()))
                .map(ratingMapper.mapToDtoRating());
    }
}
