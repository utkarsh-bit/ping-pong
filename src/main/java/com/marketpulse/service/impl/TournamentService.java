package com.marketpulse.service.impl;

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
    private List<Player> tournamentPlayers;

    // Variables to access functionalities of other services
    private RefereeService refereeService;
    private PlayerService playerService;

    private TournamentService(){
        tournamentPlayers = new ArrayList<>();
        // Get instances of helper classes
        refereeService = RefereeService.getInstance();
        playerService = PlayerService.getInstance();
    }

    /**
     * Function to make sure class is a singleton
     * @return class instance
     */
    public static TournamentService getInstance(){
        if(instance == null){
            instance = new TournamentService();
        }
        return instance;
    }

    @Override
    public void initiateTournament(List<PlayerVo> playerVo, RefereeVo refereeVo) throws Exception {

        if(playerVo.size() < 8 || null == refereeVo){
            throw new Exception("Participants count should be 9.");
        }

        // Add participants to game
        for(PlayerVo player: playerVo){
            // Add player to tournament
            tournamentPlayers.add(playerService.createPlayer(player));
        }

        refereeService.createReferee(refereeVo);

        // Referee creates the games for the tournament
        this.refereeService.startTournament(tournamentPlayers);

    }

}
