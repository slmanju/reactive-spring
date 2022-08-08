package com.slmanju.reactivesuperheroes.repository;

import com.slmanju.reactivesuperheroes.entity.Hero;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeroRepository extends ReactiveMongoRepository<Hero, String> {
}
