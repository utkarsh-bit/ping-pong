package com.marketpulse.service.impl;

import com.marketpulse.activity.IGamePlayExecutor;
import com.marketpulse.activity.impl.FinalGamePlayExecutor;
import com.marketpulse.activity.impl.LeagueGamePlayExecutor;
import com.marketpulse.activity.impl.SemiFinalGamePlayExecutor;
import com.marketpulse.constants.ApplicationConstants;
import com.marketpulse.constants.GameMode;
import com.marketpulse.constants.GameType;
import com.marketpulse.dataobjects.Game;
import com.marketpulse.dataobjects.Player;
import com.marketpulse.service.IGameService;
import com.marketpulse.utility.ApplicationUtility;

import java.util.ArrayList;
import java.util.List;

public class GameService implements IGameService {

    private static GameService instance;

    private List<Game> tournamentGames;

    private List<IGamePlayExecutor> gamePlayExecutors;

    private GameService(){
        this.tournamentGames  = new ArrayList<>();
    }

    public static GameService getInstance(){
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

    @Override
    public void createTournamentGames(List<Player> players, GameType gameType) throws Exception {

        if(null != players && players.size() != 0 && players.size()% ApplicationConstants.participantsPerGame==0){

            int iterator = players.size();
            for(int i = 0; i<iterator; i++){
                // Call to game service to create games
                this.tournamentGames.add(this.createGame(players.get(i), players.get(i+1), gameType));
            }

        }else{
            throw new Exception("Invalid Player List for game creation");
        }
    }

    @Override
    public void createGamePlayChain() {
        // Get Instance of League Game
        this.gamePlayExecutors.add(LeagueGamePlayExecutor.getInstance());
        // Get Instance of Semi Games
        this.gamePlayExecutors.add(SemiFinalGamePlayExecutor.getInstance());
        //Get Instance of Final Game
        this.gamePlayExecutors.add(FinalGamePlayExecutor.getInstance());
    }

    @Override
    public Game playGame(Game game) {
        return null;
    }
}
