package com.marketpulse.service.impl;

import com.marketpulse.ParticipantType;
import com.marketpulse.dataobjects.Game;
import com.marketpulse.dataobjects.Player;
import com.marketpulse.dataobjects.Referee;
import com.marketpulse.dataobjects.abstraction.Participants;
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

    // Variables to access functionalities of other services
    private RefereeService refereeService;
    private PlayerService playerService;

    private TournamentService(){
        tournamentGames = new ArrayList<>();
        tournamentPlayers = new ArrayList<>();

        // Get instances of helper classes
        refereeService = RefereeService.getInstance();
        playerService = PlayerService.getInstance();
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

    @Override
    public void initiateTournament(List<Participants> participants) throws Exception {

        if(participants.size() < 9){
            throw new Exception("Participants count should be 9.");
        }

        // Add participants to game
        for(Participants participant: participants){
            // Add referee to the tournament
            if(participant.getParticipantType() == ParticipantType.REFEREE){
                RefereeVo referee = new RefereeVo();
                referee.setName(participant.getName());
                this.referee = refereeService.createReferee(referee);
            }
            // Add players to the game
            else{
                PlayerVo playerVo = new PlayerVo();
                playerVo.setName(participant.getName());
                tournamentPlayers.add(playerService.createPlayer(playerVo));
            }
        }

        // Referee creates the games for the tournament
        this.refereeService.startTournament(tournamentPlayers);

    }

    private void initiateGameCreation(){

    }

}
