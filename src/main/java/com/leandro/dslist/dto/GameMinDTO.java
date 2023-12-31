package com.leandro.dslist.dto;

import com.leandro.dslist.entities.Game;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GameMinDTO {

  private Long id;
  private String title;
  private Integer year;
  private String imgUrl;
  private String shortDescription;

  public GameMinDTO(Game entity) {
    this.id = entity.getId();
    this.title = entity.getTitle();
    this.year = entity.getYear();
    this.imgUrl = entity.getImgUrl();
    this.shortDescription = entity.getShortDescription();
  }
}
