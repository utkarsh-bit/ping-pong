package com.marketpulse.activity;

import com.marketpulse.dataobjects.Game;

import java.util.List;

public interface IGamePlayExecutor {

    List<Game> execute(List<Game> games);

    boolean shouldExecute(List<Game> games);

    void notifiyReferee(List<Game> games);
}
