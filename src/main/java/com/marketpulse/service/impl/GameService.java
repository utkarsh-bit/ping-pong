package com.marketpulse.service.impl;

import com.marketpulse.dataobjects.Game;
import com.marketpulse.dataobjects.Player;
import com.marketpulse.service.IGameService;

public class GameService implements IGameService {

    @Override
    public Game createGame(Player player1, Player player2) throws Exception {

        if(player1 == null || player2 == null){
            throw new Exception("Games cannot be created with two players");
        }

        return null;

    }
}
