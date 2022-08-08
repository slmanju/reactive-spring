package com.slmanju.reactivesuperheroes.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class HeroDto {

  private String id;
  private String name;
  private List<String> powers = new ArrayList<>();

}