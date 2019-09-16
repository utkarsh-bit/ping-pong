package com.marketpulse.utility;

import java.util.Random;

public class ApplicationUtility {

    public static int getRandomNumber(int min, int max){
        Random random = new Random();

        if(min == 0 || max == 0){
            return random.nextInt();
        }
        return random.nextInt((max - min) + 1) + min;
    }
}
