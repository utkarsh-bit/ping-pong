package com.marketpulse.service.impl;

import com.marketpulse.activity.IGamePlayExecutor;
import com.marketpulse.constants.ApplicationConstants;
import com.marketpulse.constants.GameType;
import com.marketpulse.dataobjects.Game;
import com.marketpulse.dataobjects.Player;
import com.marketpulse.dataobjects.Referee;
import com.marketpulse.service.IRefereeService;
import com.marketpulse.utility.ApplicationUtility;
import com.marketpulse.viewobjects.RefereeVo;

import java.util.ArrayList;
import java.util.List;

public class RefereeService implements IRefereeService {

    private static RefereeService instance = null;

    // Helper service classes
    GameService gameService;

    private RefereeService(){
        this.gameService = GameService.getInstance();
    }

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
    public void startTournament(List<Player> players) throws Exception {

        if(null == players || players.size() == 0){
            throw new Exception("Tournament cannot start without players");
        }
        // Create tournament games for League stage
        this.gameService.createTournamentGames(players, GameType.LEAGUE);

        // Create GamePlay activity chain
        this.gameService.createGamePlayChain();
    }

    @Override
    public void displayGameResult(Game game) {

    }

    private List<IGamePlayExecutor> createGamePlayChain(){
        return null;
    }
}
