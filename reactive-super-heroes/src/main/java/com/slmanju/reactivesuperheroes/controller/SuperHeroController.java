package com.slmanju.reactivesuperheroes.controller;

import com.slmanju.reactivesuperheroes.dto.HeroDto;
import com.slmanju.reactivesuperheroes.service.HeroService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@RestController
public class SuperHeroController {

  private HeroService heroService;

  @GetMapping("super-heroes")
  public Flux<HeroDto> index() {
    return heroService.findAll();
  }

  @GetMapping("super-heroes/{id}")
  public Mono<ResponseEntity<HeroDto>> findById(@PathVariable("id") String id) {
    return heroService.findById(id)
        .map(ResponseEntity::ok)
        .defaultIfEmpty(ResponseEntity.notFound().build());
  }

  @PostMapping("super-heroes")
  public Mono<ResponseEntity<HeroDto>> save(@RequestBody Mono<HeroDto> heroDtoMono) {
    return heroService.save(heroDtoMono).map(ResponseEntity::ok);
  }

  @PutMapping("super-heroes/{id}")
  public Mono<ResponseEntity<HeroDto>> update(@PathVariable("id") String id, @RequestBody Mono<HeroDto> heroDtoMono) {
    return heroService.update(id, heroDtoMono)
        .map(ResponseEntity::ok)
        .defaultIfEmpty(ResponseEntity.badRequest().build());
  }

  @DeleteMapping("super-heroes/{id}")
  public Mono<ResponseEntity<Object>> delete(@PathVariable("id") String id) {
    return heroService.delete(id)
        .map(hero -> ResponseEntity.noContent().build())
        .defaultIfEmpty(ResponseEntity.noContent().build());
  }

}
