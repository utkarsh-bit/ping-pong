package com.marketpulse.dataobjects;

import com.marketpulse.constants.GameMode;
import com.marketpulse.dataobjects.abstraction.Participants;
import com.marketpulse.dataobjects.abstraction.Person;

public class Player extends Participants {

    private GameMode gameMode;
    private int defenceArraySize;
    private int playerPoint;

    @Override
    public String toString() {
        return "Player{" +
                "gameMode=" + gameMode +
                ", defenceArraySize=" + defenceArraySize +
                ", playerPoint=" + playerPoint +
                '}';
    }

    public GameMode getGameMode() {
        return gameMode;
    }

    public void setGameMode(GameMode gameMode) {
        this.gameMode = gameMode;
    }

    public int getDefenceArraySize() {
        return defenceArraySize;
    }

    public void setDefenceArraySize(int defenceArraySize) {
        this.defenceArraySize = defenceArraySize;
    }

    public int getPlayerPoint() {
        return playerPoint;
    }

    public void setPlayerPoint(int playerPoint) {
        this.playerPoint = playerPoint;
    }
}
