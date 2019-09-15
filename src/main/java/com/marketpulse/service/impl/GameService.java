package com.marketpulse.service.impl;

import com.marketpulse.dataobjects.Game;
import com.marketpulse.dataobjects.Player;
import com.marketpulse.service.IGameService;

import java.util.List;

public class GameService implements IGameService {

    public List<Game> createGames(List<Player> players) throws Exception {

        if(players.size() % 2 != 0){
            throw new Exception("Games cannot be created with odd numbers of players");
        }

        return null;

    }
}
