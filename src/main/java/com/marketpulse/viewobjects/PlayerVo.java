package com.marketpulse.viewobjects;

import com.marketpulse.ParticipantType;

public class PlayerVo {

    private String name;
    private int defenceArraySize;
    private ParticipantType participantType;

    @Override
    public String toString() {
        return "PlayerVo{" +
                "name='" + name + '\'' +
                ", defenceArraySize=" + defenceArraySize +
                ", participantType=" + participantType +
                '}';
    }

    public ParticipantType getParticipantType() {
        return participantType;
    }

    public void setParticipantType(ParticipantType participantType) {
        this.participantType = participantType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDefenceArraySize() {
        return defenceArraySize;
    }

    public void setDefenceArraySize(int defenceArraySize) {
        this.defenceArraySize = defenceArraySize;
    }
}
