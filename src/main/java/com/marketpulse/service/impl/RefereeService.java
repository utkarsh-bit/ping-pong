package com.marketpulse.service.impl;

import com.marketpulse.constants.ApplicationConstants;
import com.marketpulse.constants.GameType;
import com.marketpulse.dataobjects.Game;
import com.marketpulse.dataobjects.GameResult;
import com.marketpulse.dataobjects.Player;
import com.marketpulse.dataobjects.Referee;
import com.marketpulse.service.IRefereeService;
import com.marketpulse.utility.ApplicationUtility;
import com.marketpulse.viewobjects.RefereeVo;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class RefereeService implements IRefereeService {

    private static RefereeService instance = null;

    // Helper service classes
    GameService gameService;

    // Map to hold the results of the games
    Map<GameType, List<GameResult>> results;

    // Referee Object
    Referee referee;

    private RefereeService(){
        this.referee = null;
        this.gameService = GameService.getInstance();
        this.results = new LinkedHashMap<>();
    }

    /**
     * Function for getting instance of singleton class
     * @return
     */
    public static RefereeService getInstance(){
        if(null == instance){
            instance = new RefereeService();
        }
        return instance;
    }

    @Override
    public Referee createReferee(RefereeVo refereeVo) {

        int id = ApplicationUtility.getRandomNumber(0,0);

        if(null == refereeVo){
            refereeVo = new RefereeVo();
            refereeVo.setName(ApplicationConstants.refereeName.concat(Integer.toString(id)));
        }

        // Create object for a referee
        this.referee = new Referee();
        referee.setId(id);
        referee.setName(refereeVo.getName());

        return this.referee;
    }

    @Override
    public void startTournament(List<Player> players) throws Exception {

        if(null == players || players.size() < ApplicationConstants.playerCountForTournament){
            throw new Exception("Tournament cannot start without 8 players");
        }

        if(null == this.referee){
            throw new Exception("Game cannot start without referee");
        }

        // Create GamePlay activity chain
        this.gameService.createGamePlayChain();

        // start tournament
        this.gameService.startTournament(players);

        // Display final results
        displayTournamentResults();
    }

    @Override
    public void displayStageResult(List<Game> games, GameType gameType) {
        System.out.println(gameType+" STAGE RESULTS - \n");

        for (Game game: games){
            System.out.println("RESULT FOR GAME: "+game.getGameId());
            System.out.println("GAME STAGE: "+game.getGameType().toString());
            System.out.println("PARTICIPANTS: "+game.getPlayer1().getName()+" V/S "+game.getPlayer2().getName());
            String winner = game.getPlayer1().getPlayerPoint()>game.getPlayer2().getPlayerPoint()?
                    game.getPlayer1().getName() : game.getPlayer2().getName();
            System.out.println("WINNER: "+winner);
            System.out.println("***************************\n");
        }
    }

    @Override
    public void saveGameResult(Game game) {

        GameResult gameResult = new GameResult();
        // Form the result set for current game
        gameResult.setGameType(game.getGameType());
        gameResult.setWinnerName(game.getPlayer1().getPlayerPoint()>game.getPlayer2().getPlayerPoint()?
                game.getPlayer1().getName():game.getPlayer2().getName());
        gameResult.setLoserName(game.getPlayer1().getPlayerPoint()>game.getPlayer2().getPlayerPoint()?
                game.getPlayer2().getName():game.getPlayer1().getName());
        gameResult.setLoserPoint(game.getPlayer1().getPlayerPoint()>game.getPlayer2().getPlayerPoint()?
                game.getPlayer2().getPlayerPoint():game.getPlayer1().getPlayerPoint());
        gameResult.setWinnerPoints(game.getPlayer1().getPlayerPoint()>game.getPlayer2().getPlayerPoint()?
                game.getPlayer1().getPlayerPoint():game.getPlayer2().getPlayerPoint());
        gameResult.setGameId(game.getGameId());

        // Store the result for future declaration
        List<GameResult> entry;
        if(results.containsKey(game.getGameType())){
            entry = results.get(game.getGameType());
        }else{
            entry = new ArrayList<>();
        }
        entry.add(gameResult);

        results.put(game.getGameType(), entry);
    }

    @Override
    public void displayGameInfo(Game game) {
        System.out.println("GAME: "+game.getGameId());
        System.out.println("PARTICIPANTS: ");
        System.out.println(game.getPlayer1().getName()+" playing "+game.getPlayer1().getGameMode().toString());
        System.out.println(game.getPlayer2().getName()+" playing "+game.getPlayer2().getGameMode().toString()+"\n");
    }

    /**
     * Function to display the final statistics of the tournament
     */
    private void displayTournamentResults(){
        System.out.println("\n\nTOURNAMENT ENDED.\n");
        System.out.println("RESULTS: ");
        for (Map.Entry<GameType, List<GameResult>> entry: results.entrySet()){
            System.out.println("\nTOURNAMENT STAGE: "+entry.getKey().toString()+"\n");
            for (GameResult result: entry.getValue()){
                System.out.println(result.getGameId()+" : "+result.getWinnerName()+" V/S "+result.getLoserName());
                System.out.println("WINNER: "+result.getWinnerName()+". POINTS: "+result.getWinnerPoints());
                System.out.println("RUNNER-UP: "+result.getLoserName()+". POINTS: "+result.getLoserPoint());
                System.out.println("-------------------------------");
            }
        }
    }

}
