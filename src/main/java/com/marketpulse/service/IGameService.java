package com.marketpulse.service;

import com.marketpulse.dataobjects.Game;
import com.marketpulse.dataobjects.Player;

import java.util.List;

public interface IGameService {

    List<Game> createGames(List<Player> players) throws Exception;
}
