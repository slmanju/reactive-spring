package com.slmanju.reactivespringhello.service;

import com.slmanju.reactivespringhello.dto.Response;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.function.Supplier;

@Service
public class MathService {

  public Mono<Integer> square(int value) {
//    int square = value * value; // Do NOT do this
    Supplier<Integer> supplier = () -> value * value;
    return Mono.fromSupplier(supplier);
  }

  public Mono<Response> square2(int value) {
    return Mono.fromSupplier(() -> value * value)
        .map(Response::new);
  }

  public Mono<Response> square3(int value) {
    return Mono.just(value)
        .filter(i -> i >= 10)
        .filter(i -> i <= 20)
        .map(Response::new)
        .doOnSuccess(System.out::println);
  }

  public Flux<Response> multiplications(int value) {
    return Flux.range(1, 10)
        .delayElements(Duration.ofSeconds(1))
        .doOnNext(i -> System.out.println("Reactive math service is processing " + i))
//        .doOnNext(i -> {
//          try {
//            Thread.sleep(1000);
//          } catch (InterruptedException e) {
//            e.printStackTrace();
//          }
//        })
        .map(i -> i * value)
        .map(Response::new);
  }
}
