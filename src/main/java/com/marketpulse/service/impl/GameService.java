package com.marketpulse.service.impl;

import com.marketpulse.constants.GameMode;
import com.marketpulse.constants.GameType;
import com.marketpulse.dataobjects.Game;
import com.marketpulse.dataobjects.Player;
import com.marketpulse.service.IGameService;
import com.marketpulse.utility.ApplicationUtility;

public class GameService implements IGameService {

    private static GameService instance;

    private GameService(){}

    public GameService getInstance(){
        if(null == instance){
            instance = new GameService();
        }
        return instance;
    }

    @Override
    public Game createGame(Player player1, Player player2, GameType gameType) throws Exception {

        if(player1 == null || player2 == null){
            throw new Exception("Games cannot be created with two players");
        }

        int random = ApplicationUtility.getRandomNumber();

        // Set game mode for players
        if(random%2 == 0){
            player1.setGameMode(GameMode.OFFENSIVE);
        }else{
            player1.setGameMode(GameMode.DEFENSIVE);
        }
        // Create game object
        Game game = new Game();
        game.setPlayer1(player1);
        game.setPlayer2(player2);
        game.setGameType(gameType);

        return game;

    }
}
