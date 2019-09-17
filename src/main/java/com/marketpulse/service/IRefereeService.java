package com.marketpulse.service;

import com.marketpulse.constants.GameType;
import com.marketpulse.dataobjects.Game;
import com.marketpulse.dataobjects.Player;
import com.marketpulse.dataobjects.Referee;
import com.marketpulse.viewobjects.RefereeVo;

import java.util.List;

public interface IRefereeService {

    /**
     * Function to create referee for the game
     * @param refereeVo VO for referee
     */
    Referee createReferee(RefereeVo refereeVo);

    /**
     * Function to kick start the tournament
     * @param players Players participating in the tournament
     * @throws Exception If invalid args are passed
     */
    void startTournament(List<Player> players) throws Exception;

    /**
     * Function to display result at the end of each stage
     * @param games Games for which results are to be displayed
     * @param gameType Game stage type
     */
    void displayStageResult(List<Game> games, GameType gameType);

    /**
     * Function to save result of a game in order to display it at the end of the tournament
     * @param game Game object
     */
    void saveGameResult(Game game);

    /**
     * Function to display info before the start of a game
     * @param game
     */
    void displayGameInfo(Game game);
}
