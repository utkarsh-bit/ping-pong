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

    private Referee referee;
    private List<Game> tournamentGames;
    private List<Player> tournamentPlayers;

    TournamentService(){
        tournamentGames = new ArrayList<>();
        tournamentPlayers = new ArrayList<>();
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
        return null;
    }

    public Player addPlayer(PlayerVo player){
        return null;
    }

}
