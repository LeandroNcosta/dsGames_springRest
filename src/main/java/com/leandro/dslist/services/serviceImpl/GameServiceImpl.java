package com.leandro.dslist.services.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leandro.dslist.dto.GameMinDTO;
import com.leandro.dslist.entities.Game;
import com.leandro.dslist.repositories.GameRepository;
import com.leandro.dslist.services.GameService;

@Service
public class GameServiceImpl implements GameService {

  @Autowired
  private GameRepository gameRepository;

  @Override
  // public List<GameMinDTO> findAllGames() {
  public List<GameMinDTO> findAllGames() {
    List<Game> games = this.gameRepository.findAll();
    List<GameMinDTO> gameDTO = games.stream().map(x -> new GameMinDTO(x)).toList();

    return gameDTO;
  }

}
