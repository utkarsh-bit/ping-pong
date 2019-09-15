package com.marketpulse.viewobjects;

public class RefereeVo {

    private String name;

    @Override
    public String toString() {
        return "RefereeVo{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
