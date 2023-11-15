package com.leandro.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leandro.dslist.dto.GameDTO;
import com.leandro.dslist.dto.GameMinDTO;
import com.leandro.dslist.services.GameService;

@RestController
@RequestMapping("/games")
public class GameController {

  @Autowired
  private GameService gameService;

  @GetMapping
  public ResponseEntity<List<GameMinDTO>> listGames() {
    var games = this.gameService.findAllGames();

    return ResponseEntity.ok().body(games);
  }

  @GetMapping("/{id}")
  public ResponseEntity<GameDTO> getGame(@PathVariable Long id) {
    var game = this.gameService.findGameById(id);

    return ResponseEntity.ok().body(game);
  }

}
