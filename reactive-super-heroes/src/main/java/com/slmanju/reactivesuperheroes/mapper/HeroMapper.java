package com.slmanju.reactivesuperheroes.mapper;

import com.slmanju.reactivesuperheroes.dto.HeroDto;
import com.slmanju.reactivesuperheroes.entity.Hero;

public class HeroMapper {

  public static HeroDto toDto(Hero hero) {
    return new HeroDto(hero.getId(), hero.getName(), hero.getPowers());
  }

  public static Hero toEntity(HeroDto heroDto) {
    return new Hero(heroDto.getId(), heroDto.getName(), heroDto.getPowers());
  }

}
