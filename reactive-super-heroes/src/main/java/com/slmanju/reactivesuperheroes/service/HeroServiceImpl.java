package com.slmanju.reactivesuperheroes.service;

import com.slmanju.reactivesuperheroes.dto.HeroDto;
import com.slmanju.reactivesuperheroes.mapper.HeroMapper;
import com.slmanju.reactivesuperheroes.repository.HeroRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@Service
public class HeroServiceImpl implements HeroService {

  private HeroRepository heroRepository;

  @Override
  public Flux<HeroDto> findAll() {
    return heroRepository.findAll()
        .map(HeroMapper::toDto);
  }

  @Override
  public Mono<HeroDto> findById(String id) {
    return heroRepository.findById(id)
        .map(HeroMapper::toDto);
  }

  @Override
  public Mono<HeroDto> save(Mono<HeroDto> heroDtoMono) {
    return heroDtoMono.map(HeroMapper::toEntity)
        .flatMap(heroRepository::insert)
        .map(HeroMapper::toDto);
  }

  @Override
  public Mono<HeroDto> update(String id, Mono<HeroDto> heroDtoMono) {
    return heroRepository.findById(id)
        .flatMap(hero -> heroDtoMono.map(HeroMapper::toEntity))
        .doOnNext(hero -> hero.setId(id))
        .flatMap(heroRepository::save)
        .map(HeroMapper::toDto);
  }

  @Override
  public Mono<Void> delete(String id) {
    return heroRepository.deleteById(id);
  }

}
