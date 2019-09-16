package com.marketpulse.activity;

import com.marketpulse.constants.GameType;
import com.marketpulse.dataobjects.Game;
import com.marketpulse.service.impl.GameService;
import com.marketpulse.service.impl.RefereeService;

import java.util.List;

public interface IGamePlayExecutor {

    default GameService getGameServiceInstance(){
        return GameService.getInstance();
    }

    default RefereeService getRefereeServiceInstance(){
        return RefereeService.getInstance();
    }

    GameType getGameType();

    List<Game> execute(List<Game> games);

    boolean shouldExecute(List<Game> games);

    void notifyReferee(Game game);
}
