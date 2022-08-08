package com.slmanju.reactivesuperheroes.service;

import com.slmanju.reactivesuperheroes.dto.HeroDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface HeroService {

  Flux<HeroDto> findAll();

  Mono<HeroDto> findById(String id);

  Mono<HeroDto> save(Mono<HeroDto> heroDtoMono);

  Mono<HeroDto> update(String id, Mono<HeroDto> heroDtoMono);

  Mono<Void> delete(String id);

}
