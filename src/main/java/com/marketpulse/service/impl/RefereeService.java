package com.marketpulse.service.impl;

import com.marketpulse.constants.ApplicationConstants;
import com.marketpulse.dataobjects.Game;
import com.marketpulse.dataobjects.Player;
import com.marketpulse.dataobjects.Referee;
import com.marketpulse.service.IRefereeService;
import com.marketpulse.utility.ApplicationUtility;
import com.marketpulse.viewobjects.RefereeVo;

import java.util.List;

public class RefereeService implements IRefereeService {

    private static RefereeService instance = null;
    private RefereeService(){}

    /**
     * Function for getting instance of singleton class
     * @return
     */
    public static RefereeService getInstance(){
        if(null == instance){
            instance = new RefereeService();
        }
        return instance;
    }

    @Override
    public Referee createReferee(RefereeVo refereeVo) {

        int id = ApplicationUtility.getRandomNumber();

        if(null == refereeVo){
            refereeVo = new RefereeVo();
            refereeVo.setName(ApplicationConstants.refereeName.concat(Integer.toString(id)));
        }

        // Create object for a referee
        Referee referee = new Referee();
        referee.setId(id);
        referee.setName(refereeVo.getName());

        return referee;
    }

    @Override
    public List<Game> createTournamentGames(List<Player> players) {
        return null;
    }
}
