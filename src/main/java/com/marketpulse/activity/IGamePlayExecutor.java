package com.marketpulse.activity;

import com.marketpulse.constants.GameType;
import com.marketpulse.dataobjects.Game;
import com.marketpulse.dataobjects.Player;
import com.marketpulse.service.impl.GameService;
import com.marketpulse.service.impl.RefereeService;

import java.util.List;

public interface IGamePlayExecutor {

    /**
     * Method to return instance of game service to access the services
     * @return Instance of GameService
     */
    default GameService getGameServiceInstance(){
        return GameService.getInstance();
    }

    /**
     * Method to return instance of referee service to access the services
     * @return Instance of RefereeService
     */
    default RefereeService getRefereeServiceInstance(){
        return RefereeService.getInstance();
    }

    /**
     * Function to notify the referee about the game result
     * @param game
     */
    default void notifyReferee(Game game) {
        // Add game to result holder
        this.getRefereeServiceInstance().saveGameResult(game);
    }

    /**
     * Function to display result at each stage of game
     * @param games Games for which results are to be displayed
     * @param gameType Current stage type
     */
    default void displayStageResults(List<Game> games, GameType gameType){
        // Notify referee for the same
        this.getRefereeServiceInstance().displayStageResult(games, gameType);
    }

    /**
     * Function to get game type of current stage of tournament
     * @return
     */
    GameType getGameType();

    /**
     * Driver function for the activities
     * @param games games to be played
     * @return updated game objects
     * @throws Exception If incorrect parameters are passed
     */
    List<Game> execute(List<Game> games) throws Exception;

    /**
     * Function to identify whether activity should be executed or not
     * @param games
     * @return
     */
    boolean shouldExecute(List<Game> games);

    /**
     * Function to create games for the current stage of tournament
     * @param players players involved in games
     * @throws Exception
     */
    void createStageGames(List<Player> players) throws Exception;
}
