package com.slmanju.reactivespringhello.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class HelloController {

  @GetMapping("mono")
  public Mono<String> helloMono() {
    return Mono.just("Hello Reactive Programming");
  }

  @GetMapping("flux")
  public Flux<String> helloFlux() {
    return Flux.just("Hello", "Reactive", "Programming");
  }

  @GetMapping("flux2")
  public Flux<String> helloFlux2() {
    return Flux.just("Apple", "Orange", "Banana", "Avocado", "Mango")
        .doOnNext(fruit -> System.out.println("Processing " + fruit))
        .filter(fruit -> fruit.startsWith("A"))
        .map(String::toUpperCase)
        .doOnSubscribe(subscription -> System.out.println("Subscribed to Fruit stream"))
        .doOnComplete(() -> System.out.println("Fruit stream completed"))
        .doOnTerminate(() -> System.out.println("Fruit stream terminated"));
  }

}
