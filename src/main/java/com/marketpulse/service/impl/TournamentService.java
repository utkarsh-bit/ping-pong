package com.marketpulse.service.impl;

import com.marketpulse.constants.ApplicationConstants;
import com.marketpulse.dataobjects.Game;
import com.marketpulse.dataobjects.Player;
import com.marketpulse.dataobjects.Referee;
import com.marketpulse.service.ITournamentService;
import com.marketpulse.viewobjects.PlayerVo;
import com.marketpulse.viewobjects.RefereeVo;

import java.util.ArrayList;
import java.util.List;

public class TournamentService implements ITournamentService {

    private static TournamentService instance;

    private Referee referee;
    private List<Game> tournamentGames;
    private List<Player> tournamentPlayers;

    private TournamentService(){
        tournamentGames = new ArrayList<>();
        tournamentPlayers = new ArrayList<>();
    }

    /**
     * Function to make sure class is a singleton
     * @return class instance
     */
    public TournamentService getInstance(){
        if(instance == null){
            instance = new TournamentService();
        }
        return instance;
    }

    public void initiateTournament(List<PlayerVo> players) throws Exception {

        if(players.size() < 8){
            throw new Exception("Players cannot be less than 8.");
        }

        // Add referee to the Game
        RefereeVo referee = new RefereeVo();
        referee.setName(ApplicationConstants.refereeName);
        this.referee = addReferee(referee);

        // Add players to game
        for(PlayerVo playerVo: players){
            tournamentPlayers.add(addPlayer(playerVo));
        }



    }

    public Referee addReferee(RefereeVo refereeVo){

        Referee referee = new Referee();

        if(null == refereeVo){
            referee.setName(ApplicationConstants.refereeName);

        }else{

        }
        return referee;
    }

    public Player addPlayer(PlayerVo player){
        return null;
    }

}
