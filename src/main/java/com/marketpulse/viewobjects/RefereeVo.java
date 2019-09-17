package com.marketpulse.viewobjects;

import com.marketpulse.constants.ParticipantType;

public class RefereeVo {

    private String name;
    private ParticipantType participantType;

    @Override
    public String toString() {
        return "RefereeVo{" +
                "name='" + name + '\'' +
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
}
