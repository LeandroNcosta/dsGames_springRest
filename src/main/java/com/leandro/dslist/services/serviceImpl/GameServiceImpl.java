package com.leandro.dslist.services.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.leandro.dslist.dto.GameDTO;
import com.leandro.dslist.dto.GameMinDTO;
import com.leandro.dslist.entities.Game;
import com.leandro.dslist.projections.GameMinProjection;
import com.leandro.dslist.repositories.GameRepository;
import com.leandro.dslist.services.GameService;

@Service
public class GameServiceImpl implements GameService {

  @Autowired
  private GameRepository gameRepository;

  @Override
  @Transactional(readOnly = true) // annotacion para indicar apenas leitura/ consultas no bd ACID
  // public List<GameMinDTO> findAllGames() {
  public List<GameMinDTO> findAllGames() {
    List<Game> games = this.gameRepository.findAll();
    // percorrendo pela lista e transformando game para gameDTO
    List<GameMinDTO> gamesDTO = games.stream().map(x -> new GameMinDTO(x)).toList();

    return gamesDTO;
  }

  @Override
  @Transactional(readOnly = true)
  public GameDTO findGameById(Long id) {
    var game = this.gameRepository.findById(id).orElse(null);
    var gameDTO = new GameDTO(game);

    return gameDTO;
  }

  @Override
  @Transactional(readOnly = true)
  public List<GameMinDTO> searchGameByList(Long listId) {
    List<GameMinProjection> games = this.gameRepository.searchByList(listId);

    List<GameMinDTO> gamesDTO = games.stream().map(x -> new GameMinDTO(x)).toList();

    return gamesDTO;
  }

}
