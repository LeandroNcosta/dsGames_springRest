package com.leandro.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leandro.dslist.dto.GameListDTO;
import com.leandro.dslist.dto.GameMinDTO;
import com.leandro.dslist.services.GameListService;
import com.leandro.dslist.services.GameService;

@RestController
@RequestMapping("/lists")
public class GameListController {

  @Autowired
  private GameListService gameListService;

  @Autowired
  private GameService gameService;

  @GetMapping
  public ResponseEntity<List<GameListDTO>> gameLists() {
    var gameListsDTO = this.gameListService.findAllGameList();

    return ResponseEntity.ok().body(gameListsDTO);
  }

  @GetMapping("/{listId}/games")
  public ResponseEntity<List<GameMinDTO>> searchGamesByList(@PathVariable Long listId) {
    var games = this.gameService.searchGameByList(listId);

    return ResponseEntity.ok().body(games);
  }
}
