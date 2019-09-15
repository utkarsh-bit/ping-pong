package com.marketpulse.service;

import com.marketpulse.dataobjects.Game;
import com.marketpulse.dataobjects.Player;

import java.util.List;

public interface IGameService {

    Game createGame(Player player1, Player player2) throws Exception;
}
