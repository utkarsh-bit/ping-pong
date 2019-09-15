package com.marketpulse.service.impl;

import com.marketpulse.constants.ApplicationConstants;
import com.marketpulse.dataobjects.Player;
import com.marketpulse.service.IPlayerService;
import com.marketpulse.utility.ApplicationUtility;
import com.marketpulse.viewobjects.PlayerVo;

public class PlayerService implements IPlayerService {

    private static PlayerService instance = null;

    private PlayerService(){}

    /**
     * Singleton design pattern application
     * @return Instance of clas
     */
    public static PlayerService getInstance(){
        if(null == instance){
            instance = new PlayerService();
        }
        return instance;
    }

    @Override
    public Player createPlayer(PlayerVo playerVo){

        // Get a random Id for player
        int id = ApplicationUtility.getRandomNumber();

        if(null == playerVo){
            playerVo = new PlayerVo();
            playerVo.setName(
                    ApplicationConstants.dummyPlayerPrefix.concat(Integer.toString(id)));

        }
        // Create player object
        Player player = new Player();
        player.setId(id);
        player.setName(playerVo.getName());

        return player;
    }

}
