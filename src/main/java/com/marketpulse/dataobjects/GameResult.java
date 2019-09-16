package com.marketpulse.dataobjects;

import com.marketpulse.constants.GameType;

public class GameResult {

    private String winnerName;
    private int winnerPoints;
    private String loserName;
    private int loserPoint;
    private GameType gameType;

    @Override
    public String toString() {
        return "GameResult{" +
                "winnerName='" + winnerName + '\'' +
                ", winnerPoints=" + winnerPoints +
                ", loserName='" + loserName + '\'' +
                ", loserPoint=" + loserPoint +
                ", gameType=" + gameType +
                '}';
    }

    public String getWinnerName() {
        return winnerName;
    }

    public void setWinnerName(String winnerName) {
        this.winnerName = winnerName;
    }

    public int getWinnerPoints() {
        return winnerPoints;
    }

    public void setWinnerPoints(int winnerPoints) {
        this.winnerPoints = winnerPoints;
    }

    public String getLoserName() {
        return loserName;
    }

    public void setLoserName(String loserName) {
        this.loserName = loserName;
    }

    public int getLoserPoint() {
        return loserPoint;
    }

    public void setLoserPoint(int loserPoint) {
        this.loserPoint = loserPoint;
    }

    public GameType getGameType() {
        return gameType;
    }

    public void setGameType(GameType gameType) {
        this.gameType = gameType;
    }
}
