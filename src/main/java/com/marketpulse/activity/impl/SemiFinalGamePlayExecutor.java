package com.marketpulse.activity.impl;

import com.marketpulse.activity.IGamePlayExecutor;
import com.marketpulse.constants.ApplicationConstants;
import com.marketpulse.constants.GameType;
import com.marketpulse.dataobjects.Game;
import com.marketpulse.dataobjects.Player;

import java.util.List;

public class SemiFinalGamePlayExecutor implements IGamePlayExecutor {

    private static SemiFinalGamePlayExecutor instance;

    private SemiFinalGamePlayExecutor(){}

    public static SemiFinalGamePlayExecutor getInstance(){
        if(null == instance){
            instance = new SemiFinalGamePlayExecutor();
        }
        return instance;
    }

    @Override
    public GameType getGameType() {
        return GameType.SEMIS;
    }

    @Override
    public List<Game> execute(List<Game> games) throws Exception {

        if(shouldExecute(games)){
            for (Game game: games){
                // Execute current game play
                this.getGameServiceInstance().playGame(game);
                // Notify referee for game result
                this.notifyReferee(game);
            }
        }else {
            throw new Exception(games.get(0).getGameType().toString()+": Stage games failed to execute.");
        }
        return games;
    }

    @Override
    public boolean shouldExecute(List<Game> games) {

        // Return false if count of games for this stage is not 4 or GameType is not LEAGUE
        if(games.size() < ApplicationConstants.semiFinalsGameSize ||
                !games.get(0).getGameType().toString().equalsIgnoreCase(GameType.SEMIS.toString())){
            return false;
        }
        return true;
    }

//    @Override
//    public void notifyReferee(Game game) {
//        // Notify referee to display result
//        this.getRefereeServiceInstance().displayGameResult(game);
//        // Add game to result holder
//        this.getRefereeServiceInstance().saveGameResult(game);
//    }

    @Override
    public void createStageGames(List<Player> players) throws Exception {
        // Create game for SemiFinal stage
        this.getGameServiceInstance().createTournamentStageGames(players, getGameType());
    }

}
