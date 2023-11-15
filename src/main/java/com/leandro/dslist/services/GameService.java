package com.leandro.dslist.services;

import java.util.List;

import com.leandro.dslist.dto.GameDTO;
import com.leandro.dslist.dto.GameMinDTO;

public interface GameService {
  List<GameMinDTO> findAllGames();

  GameDTO findGameById(Long id);

  List<GameMinDTO> searchGameByList(Long listId);
}
