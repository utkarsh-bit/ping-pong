package com.marketpulse.constants;

import java.util.ArrayList;
import java.util.List;

public interface ApplicationConstants {

    String refereeName = "DUMMY_REFEREE";
    String dummyPlayerPrefix = "PLAYER_";
    String gameIdPrefix = "GAME-";

    int participantsPerGame = 2;
    int leagueGameSize = 4;
    int semiFinalsGameSize = 2;
    int finalGameSize = 1;
    int defaultDefensiveArraySize = 5;

    int minBoundForRandomNumGeneration = 1;
    int maxBoundForRandomNumGeneration = 10;

    int upperBoundForPlayerPoints = 5;

    List<Integer> gameMoveValues = new ArrayList<Integer>(){{
            add(0); add(1); add(2); add(3); add(4);
            add(5); add(6); add(7); add(8); add(9);
    }};
}

