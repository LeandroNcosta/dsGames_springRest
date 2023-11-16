package com.leandro.dslist.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.leandro.dslist.entities.Game;
import com.leandro.dslist.projections.GameMinProjection;

public interface GameRepository extends JpaRepository<Game, Long> {
  // querys personalizada
  @Query(nativeQuery = true, value = """
      SELECT tb_game.id, tb_game.title, tb_game.game_year AS gameYear, tb_game.img_url AS imgUrl,
      tb_game.short_description AS shortDescription, tb_belonging.position
      FROM tb_game
      INNER JOIN tb_belonging ON tb_game.id = tb_belonging.game_id
      WHERE tb_belonging.list_id = :listId
      ORDER BY tb_belonging.position
      	""")
  List<GameMinProjection> searchByList(Long listId);
  // o id do metodo é referenciado com :listid na query sql
  // o método precisa de uma interface com metodos get dos campos que vao retornar
  // no select
}
