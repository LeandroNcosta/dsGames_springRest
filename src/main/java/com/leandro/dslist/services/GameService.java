package com.leandro.dslist.services;

import java.util.List;

import com.leandro.dslist.dto.GameMinDTO;

public interface GameService {
  List<GameMinDTO> findAllGames();

}
