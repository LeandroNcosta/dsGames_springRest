package com.leandro.dslist.services;

import java.util.List;

import com.leandro.dslist.dto.GameListDTO;

public interface GameListService {
  List<GameListDTO> findAllGameList();
}
