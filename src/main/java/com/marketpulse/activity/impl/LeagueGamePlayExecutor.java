package com.marketpulse.activity.impl;

import com.marketpulse.activity.IGamePlayExecutor;
import com.marketpulse.constants.ApplicationConstants;
import com.marketpulse.constants.GameType;
import com.marketpulse.dataobjects.Game;
import com.marketpulse.dataobjects.Player;

import java.util.List;

public class LeagueGamePlayExecutor implements IGamePlayExecutor {

    private static LeagueGamePlayExecutor instance;

    private LeagueGamePlayExecutor(){}

    public static LeagueGamePlayExecutor getInstance(){
        if(null == instance){
            instance = new LeagueGamePlayExecutor();
        }

        return instance;
    }

    @Override
    public GameType getGameType() {
        return GameType.LEAGUE;
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

        }else{
            throw new Exception("League games execution cannot be processed.");
        }

        return games;
    }

    @Override
    public boolean shouldExecute(List<Game> games) {
        // Return false if count of games for this stage is not 4 or GameType is not LEAGUE
        if(games.size() < ApplicationConstants.leagueGameSize ||
                !games.get(0).getGameType().toString().equalsIgnoreCase(GameType.LEAGUE.toString())){
            return false;
        }
        return true;
    }

    @Override
    public void createStageGames(List<Player> players) throws Exception {
        // Create games for league stage
        this.getGameServiceInstance().createTournamentStageGames(players, getGameType());
    }

}
