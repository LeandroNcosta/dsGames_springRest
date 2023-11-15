package com.leandro.dslist.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Table(name = "tb_belonging")
@Entity
@Data
public class Belonging {

  @Id
  private BelongingPK id = new BelongingPK();

  private Integer position;

  // construtor
  public Belonging(Game game, GameList gameList, Integer position) {
    id.setGame(game);
    id.setList(gameList);
    this.position = position;
  }
}
