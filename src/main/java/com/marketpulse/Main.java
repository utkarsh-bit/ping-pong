package com.marketpulse;

import com.marketpulse.service.impl.TournamentService;
import com.marketpulse.viewobjects.PlayerVo;
import com.marketpulse.viewobjects.RefereeVo;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    private static final Logger logger = Logger.getLogger("Main");

    static List<PlayerVo> players;

    static RefereeVo referee;

    /**
     * Driver class to initiate the game
     * @param args
     */
    public static void main(String[] args){
        try{
            // Create players for tournament
            createTournamentParticipants();
            // Start Tournament
            TournamentService.getInstance().initiateTournament(players, referee);

            System.out.println("");

        }catch (Exception e){
            logger.log(Level.FINE, "Error while executing tournament. Please contact System Admin", e);
        }

    }

    private static void createTournamentParticipants(){
        players = new ArrayList<>();

        // Add referee
        referee = new RefereeVo();
        referee.setName("Referee");
        referee.setParticipantType(ParticipantType.REFEREE);

        // Add Players
        PlayerVo player1 = new PlayerVo();
        player1.setName("Joey");
        player1.setDefenceArraySize(7);
        player1.setParticipantType(ParticipantType.PLAYER);
        players.add(player1);

        PlayerVo player2 = new PlayerVo();
        player2.setName("Monica");
        player2.setDefenceArraySize(6);
        player2.setParticipantType(ParticipantType.PLAYER);
        players.add(player2);


        PlayerVo player3 = new PlayerVo();
        player3.setName("Chandler");
        player3.setDefenceArraySize(6);
        player3.setParticipantType(ParticipantType.PLAYER);
        players.add(player3);


        PlayerVo player4 = new PlayerVo();
        player4.setName("Ross");
        player4.setDefenceArraySize(5);
        player4.setParticipantType(ParticipantType.PLAYER);
        players.add(player4);


        PlayerVo player5 = new PlayerVo();
        player5.setName("Phoebe");
        player5.setDefenceArraySize(5);
        player5.setParticipantType(ParticipantType.PLAYER);
        players.add(player5);


        PlayerVo player6 = new PlayerVo();
        player6.setName("Rachel");
        player6.setDefenceArraySize(6);
        player6.setParticipantType(ParticipantType.PLAYER);
        players.add(player6);


        PlayerVo player7 = new PlayerVo();
        player7.setName("Sachin");
        player7.setDefenceArraySize(4);
        player7.setParticipantType(ParticipantType.PLAYER);
        players.add(player7);


        PlayerVo player8 = new PlayerVo();
        player8.setName("Rohan");
        player8.setDefenceArraySize(5);
        player8.setParticipantType(ParticipantType.PLAYER);
        players.add(player8);


    }
}
