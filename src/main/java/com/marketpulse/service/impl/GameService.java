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
import com.marketpulse.utility.GamePlayUtility;

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

        int random = ApplicationUtility.getRandomNumber(0,0);

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
    public Game playGame(Game game) throws InterruptedException {

        // Initiate the game
        while(game.getPlayer1().getPlayerPoint() < 5 || game.getPlayer2().getPlayerPoint() < 5){

            // Thread for player1 move
            GamePlayUtility gamePlayUtilityP1 = new GamePlayUtility(game.getPlayer1());
            // Thread for player2 move
            GamePlayUtility gamePlayUtilityP2 = new GamePlayUtility(game.getPlayer2());

            // run for player1
            gamePlayUtilityP1.start();
            //run for player2
            gamePlayUtilityP2.start();

            // Wait for process to complete
            gamePlayUtilityP1.join();
            gamePlayUtilityP2.join();

            // Analyze the move
            game = evaluateResult(game, gamePlayUtilityP1.getResult(), gamePlayUtilityP2.getResult());

        }

        return game;
    }

    private Game evaluateResult(Game game, List<Integer> resultPlayer1, List<Integer> resultPlayer2){

        // If player1 was playing OFFENSIVE
        if(game.getPlayer1().getGameMode().toString().equalsIgnoreCase(GameMode.OFFENSIVE.toString())){
            // Check whether the offensive move is present in defense array
            if(resultPlayer2.contains(resultPlayer1.get(0))){
                // Defense successful
                // Add point to player2 and change GameModes for both players
                game.getPlayer2().setPlayerPoint(game.getPlayer2().getPlayerPoint()+1);
                game.getPlayer1().setGameMode(GameMode.DEFENSIVE);
                game.getPlayer2().setGameMode(GameMode.OFFENSIVE);
            }
            // Defence fails
            else{
                // Increase player1's point
                game.getPlayer1().setPlayerPoint(game.getPlayer1().getPlayerPoint()+1);
            }
        }
        // If player2 was playing OFFENSIVE
        else{
            // Check whether the offensive move is present in defense array
            if(resultPlayer1.contains(resultPlayer2.get(0))){
                // Defense successful
                // Add point to player2 and change GameModes for both players
                game.getPlayer1().setPlayerPoint(game.getPlayer1().getPlayerPoint()+1);
                game.getPlayer2().setGameMode(GameMode.DEFENSIVE);
                game.getPlayer1().setGameMode(GameMode.OFFENSIVE);
            }
            // Defence fails
            else{
                // Increase player1's point
                game.getPlayer2().setPlayerPoint(game.getPlayer2().getPlayerPoint()+1);
            }
        }

        return game;
    }
}
