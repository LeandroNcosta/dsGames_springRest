package com.leandro.dslist.dto;

import com.leandro.dslist.entities.Game;
import com.leandro.dslist.projections.GameMinProjection;

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

  // contrutor para converter entidades para o DTO
  public GameMinDTO(Game entity) {
    this.id = entity.getId();
    this.title = entity.getTitle();
    this.year = entity.getYear();
    this.imgUrl = entity.getImgUrl();
    this.shortDescription = entity.getShortDescription();
  }

  // contrutor para converter Projections para o DTO
  public GameMinDTO(GameMinProjection projection) {
    this.id = projection.getId();
    this.title = projection.getTitle();
    this.year = projection.getGameYear();
    this.imgUrl = projection.getImgUrl();
    this.shortDescription = projection.getShortDescription();
  }
}
