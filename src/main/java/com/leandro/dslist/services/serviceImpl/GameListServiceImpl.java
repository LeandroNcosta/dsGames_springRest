package com.leandro.dslist.services.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.leandro.dslist.dto.GameListDTO;
import com.leandro.dslist.repositories.GameListRepository;
import com.leandro.dslist.services.GameListService;

@Service
public class GameListServiceImpl implements GameListService {

  @Autowired
  private GameListRepository gameListRepository;

  @Override
  @Transactional(readOnly = true)
  public List<GameListDTO> findAllGameList() {
    var gameLists = this.gameListRepository.findAll();
    var gameListsDTO = gameLists.stream().map(x -> new GameListDTO(x)).toList();

    return gameListsDTO;
  }
}
