package com.marketpulse.activity.impl;

import com.marketpulse.activity.IGamePlayExecutor;
import com.marketpulse.dataobjects.Game;

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
