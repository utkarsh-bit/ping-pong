package com.marketpulse.utility;

import com.marketpulse.constants.ApplicationConstants;
import com.marketpulse.constants.GameMode;
import com.marketpulse.dataobjects.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class will be used to create threads in order run OFFENSIVE and DEFENSIVE PLAY simultaneously
 */
public class GamePlayUtility extends Thread {

    Player player;
    List<Integer> gameMoveValues;

    List<Integer> result;

    public GamePlayUtility(Player player){
        this.player = player;
        this.gameMoveValues = ApplicationConstants.gameMoveValues;
        this.result = new ArrayList<>();
    }

    public void run(){
        // If move if OFFENSIVE
        if(this.player.getGameMode().toString().equalsIgnoreCase(GameMode.OFFENSIVE.toString())){
            // Get a random number in range (0..9)
            result.add(ApplicationUtility.getRandomNumber(ApplicationConstants.minBoundForRandomNumGeneration,
                    ApplicationConstants.maxBoundForRandomNumGeneration));
        }
        // Else move is DEFENSIVE
        else{
            // Copy moves to result
            result.addAll(gameMoveValues);
            // Shuffle the move values to randomize the data
            Collections.shuffle(result);
            // Trim the array according to players defense array size
            result = result.subList(0, player.getDefenceArraySize());
        }
    }

    public List<Integer> getResult(){
        return this.result;
    }
}
