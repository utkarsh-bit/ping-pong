package com.marketpulse.activity.impl;

import com.marketpulse.activity.IGamePlayExecutor;
import com.marketpulse.constants.GameType;
import com.marketpulse.dataobjects.Game;

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
    public List<Game> execute(List<Game> games) {
        return null;
    }

    @Override
    public boolean shouldExecute(List<Game> games) {
        return false;
    }

    @Override
    public void notifyReferee(Game game) {
        // Notify referee to display result
        this.getRefereeServiceInstance().displayGameResult(game);
    }

}
