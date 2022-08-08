package com.slmanju.reactivesuperheroes.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data @AllArgsConstructor @NoArgsConstructor @ToString
@Document("heroes")
public class Hero {

  @Id
  private String id;
  private String name;
  private List<String> powers = new ArrayList<>();

}
