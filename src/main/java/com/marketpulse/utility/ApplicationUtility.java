package com.marketpulse.utility;

import java.util.Random;

public class ApplicationUtility {

    public static int getRandomNumber(){
        Random random = new Random();
        return random.nextInt();
    }
}
