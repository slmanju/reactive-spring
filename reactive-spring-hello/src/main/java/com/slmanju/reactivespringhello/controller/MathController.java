package com.slmanju.reactivespringhello.controller;

import com.slmanju.reactivespringhello.dto.Response;
import com.slmanju.reactivespringhello.service.MathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class MathController {

  @Autowired
  private MathService mathService;

  @GetMapping("square/{input}")
  public Mono<Integer> square(@PathVariable("input") int input) {
    return mathService.square(input);
  }

  @GetMapping("square2/{input}")
  public Mono<ResponseEntity<Response>> square2(@PathVariable("input") int input) {
    return mathService.square2(input)
            .map(ResponseEntity::ok);
  }

  @GetMapping("square3/{input}")
  public Mono<ResponseEntity<Response>> square3(@PathVariable("input") int input) {
    return mathService.square3(input)
        .map(ResponseEntity::ok)
        .defaultIfEmpty(ResponseEntity.badRequest().build());
  }

  @GetMapping("multiplications/{input}")
  public Flux<Response> multiplications(@PathVariable("input") int input) {
    return mathService.multiplications(input);
  }
}
