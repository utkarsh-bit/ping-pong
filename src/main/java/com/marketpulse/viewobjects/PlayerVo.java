package com.marketpulse.viewobjects;

public class PlayerVo {

    private String name;
    private int defenceArratSize;

    @Override
    public String toString() {
        return "PlayerVo{" +
                "name='" + name + '\'' +
                ", defenceArratSize=" + defenceArratSize +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDefenceArratSize() {
        return defenceArratSize;
    }

    public void setDefenceArratSize(int defenceArratSize) {
        this.defenceArratSize = defenceArratSize;
    }
}
