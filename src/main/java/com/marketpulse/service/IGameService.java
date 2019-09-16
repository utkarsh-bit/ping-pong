package com.marketpulse.service;

import com.marketpulse.constants.GameType;
import com.marketpulse.dataobjects.Game;
import com.marketpulse.dataobjects.Player;

import java.util.List;

public interface IGameService {

    /**
     * Function will create a Game object
     * @param player1 First participant
     * @param player2 Second participant
     * @param gameType Type of game to be played
     * @return Created game object
     * @throws Exception If invalid params are passed
     */
    Game createGame(Player player1, Player player2, GameType gameType) throws Exception;

    /**
     * Function to create games of the Stages according to gametype
     * @param players Players involved in game
     * @param gameType Type of Game stage
     * @throws Exception if invalid params are passed
     */
    void createTournamentStageGames(List<Player> players, GameType gameType) throws Exception;

    /**
     * Function will create a chain for Games according to stages in tournament
     */
    void createGamePlayChain();

    /**
     * Function to initiate the play for a particular game
     * @param game Game to be played
     * @return Resultant Game Object
     */
    Game playGame(Game game) throws InterruptedException;

    void startTournament(List<Player> players) throws Exception;
}
