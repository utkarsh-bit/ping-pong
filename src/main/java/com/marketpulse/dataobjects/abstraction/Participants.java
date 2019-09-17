package com.marketpulse.dataobjects.abstraction;


import com.marketpulse.constants.ParticipantType;

public class Participants {

    private int id;
    private String name;
    private ParticipantType participantType;

    @Override
    public String toString() {
        return "Participants{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", participantType=" + participantType +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ParticipantType getParticipantType() {
        return participantType;
    }

    public void setParticipantType(ParticipantType participantType) {
        this.participantType = participantType;
    }
}

