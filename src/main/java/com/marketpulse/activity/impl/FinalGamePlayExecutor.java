package com.marketpulse.activity.impl;

import com.marketpulse.activity.IGamePlayExecutor;
import com.marketpulse.dataobjects.Game;

import java.util.List;

public class FinalGamePlayExecutor implements IGamePlayExecutor {

    private static FinalGamePlayExecutor instance;

    private FinalGamePlayExecutor(){}

    public static FinalGamePlayExecutor getInstance(){
        if(null == instance){
            instance = new FinalGamePlayExecutor();
        }
        return instance;
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
    public void notifiyReferee(List<Game> games) {

    }
}
