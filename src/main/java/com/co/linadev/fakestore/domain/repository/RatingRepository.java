package com.co.linadev.fakestore.domain.repository;

import com.co.linadev.fakestore.domain.collections.Rating;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingRepository extends ReactiveMongoRepository<Rating, String> {
}
