package com.marketpulse;

import com.marketpulse.constants.ApplicationConstants;
import com.marketpulse.constants.GameMode;
import com.marketpulse.constants.GameType;
import com.marketpulse.dataobjects.Game;
import com.marketpulse.dataobjects.Player;
import com.marketpulse.dataobjects.Referee;
import com.marketpulse.service.impl.GameService;
import com.marketpulse.service.impl.PlayerService;
import com.marketpulse.service.impl.RefereeService;
import com.marketpulse.viewobjects.PlayerVo;
import com.marketpulse.viewobjects.RefereeVo;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

public class ApplicationTest {

    // Test cases for referee service

    @Test
    public void testRefereeCreation(){
        RefereeVo refereeVo = new RefereeVo();
        refereeVo.setName("ABC");
        Referee referee = RefereeService.getInstance().createReferee(refereeVo);
        Assertions.assertEquals(referee.getName(), "ABC");
    }

    @Test
    public void testNullRefereeCreation(){
        Referee referee = RefereeService.getInstance().createReferee(null);
        boolean out = referee.getName().contains(ApplicationConstants.refereeName);
        Assertions.assertTrue(out);
    }

    @Test
    public void testStartTournamentWithNullPlayers(){
        Boolean out = false;
        try {
            RefereeService.getInstance().startTournament(null);
        }catch (Exception e){
            out = true;
        }
        Assertions.assertTrue(out);
    }

    @Test
    public void testStartTournamentWithLessPlayers(){
        Boolean out = false;
        try {
            Player player1 = new Player();
            Player player2 = new Player();
            List<Player> players = new ArrayList<Player>(){{
                add(player1);
                add(player2);
            }};
            RefereeService.getInstance().startTournament(players);
        }catch (Exception e){
            out = true;
        }
        Assertions.assertTrue(out);
    }

    // Test cases for player service

    @Test
    public void testPlayerCreationWithNull(){

        Player player = PlayerService.getInstance().createPlayer(null);
        Boolean out = player.getName().contains(ApplicationConstants.dummyPlayerPrefix);
        Assertions.assertTrue(out);
    }

    @Test
    public void testPlayerCreationWithVO(){

        PlayerVo playerVo = new PlayerVo();
        playerVo.setName("TEST");
        Player player = PlayerService.getInstance().createPlayer(playerVo);
        Assertions.assertEquals(player.getName(), "TEST");
    }

    // Game service test cases
    @Test
    public void testPlayGame() throws InterruptedException {

        Game game = new Game();
        Player player1 = new Player();
        Player player2 = new Player();
        player1.setName("t1");
        player1.setPlayerPoint(0);
        player2.setPlayerPoint(0);

        player1.setGameMode(GameMode.DEFENSIVE);
        player2.setGameMode(GameMode.OFFENSIVE);

        game.setPlayer1(player1);
        game.setPlayer2(player2);

        GameService.getInstance().playGame(game);

        Assertions.assertTrue(game.getPlayer1().getPlayerPoint() == 5 ||
                game.getPlayer2().getPlayerPoint() == 5);
    }

    @Test
    public void testGameModeChange() throws InterruptedException {

        Game game = new Game();
        Player player1 = new Player();
        Player player2 = new Player();
        player1.setName("t1");
        player1.setPlayerPoint(0);
        player2.setPlayerPoint(0);

        player1.setGameMode(GameMode.OFFENSIVE);
        player2.setGameMode(GameMode.DEFENSIVE);

        game.setPlayer1(player1);
        game.setPlayer2(player2);

        List<Integer> player1Move = new ArrayList<Integer>(){{ add(2);}};
        List<Integer> player2Move = new ArrayList<Integer>(){{ add(1);add(2);add(3);add(4);}};

        GameService.getInstance().evaluateResult(game, player1Move,player2Move);

        Assertions.assertTrue(game.getPlayer1().getGameMode().equals(GameMode.DEFENSIVE));
        Assertions.assertTrue(game.getPlayer2().getGameMode().equals(GameMode.OFFENSIVE));
    }

    @Test
    public void testLeagueStageGameCreation() {

        // League test
        List<Player> leaguePlayers = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            Player player = new Player();
            player.setName("TEST" + i);
            leaguePlayers.add(player);
        }

        // Call to test league
        String resultMsg = "";
        try {
            GameService.getInstance().createTournamentStageGames(leaguePlayers, GameType.LEAGUE);
        } catch (Exception e) {
            resultMsg = e.getMessage();
        }

        Assertions.assertEquals("INVALID COUNT OF PlAYERS FOR LEAGUE STAGE.", resultMsg);

        for (int i = 0; i < 2; i++) {
            Player player = new Player();
            player.setName("TEST" + i+6);
            leaguePlayers.add(player);
        }

        try {
            GameService.getInstance().createTournamentStageGames(leaguePlayers, GameType.LEAGUE);
            resultMsg = "";
        } catch (Exception e) {
            resultMsg = e.getMessage();
        }

        Assertions.assertEquals("", resultMsg);

    }
    @Test
    public void testSemiStageGameCreation() {

        // League test
        List<Player> leaguePlayers = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Player player = new Player();
            player.setName("TEST" + i);
            leaguePlayers.add(player);
        }

        // Call to test league
        String resultMsg = "";
        try {
            GameService.getInstance().createTournamentStageGames(leaguePlayers, GameType.SEMIS);
        } catch (Exception e) {
            resultMsg = e.getMessage();
        }

        Assertions.assertEquals("INVALID COUNT OF PlAYERS FOR SEMI STAGE.", resultMsg);

        for (int i = 0; i < 1; i++) {
            Player player = new Player();
            player.setName("TEST" + i+3);
            leaguePlayers.add(player);
        }

        try {
            GameService.getInstance().createTournamentStageGames(leaguePlayers, GameType.SEMIS);
            resultMsg = "";
        } catch (Exception e) {
            resultMsg = e.getMessage();
        }

        Assertions.assertEquals("", resultMsg);

    }
    @Test
    public void testFinalStageGameCreation() {

        // League test
        List<Player> leaguePlayers = new ArrayList<>();
        for (int i = 0; i < 1; i++) {
            Player player = new Player();
            player.setName("TEST" + i);
            leaguePlayers.add(player);
        }

        // Call to test league
        String resultMsg = "";
        try {
            GameService.getInstance().createTournamentStageGames(leaguePlayers, GameType.FINAL);
        } catch (Exception e) {
            resultMsg = e.getMessage();
        }

        Assertions.assertEquals("INVALID COUNT OF PlAYERS FOR FINAL STAGE.", resultMsg);

        for (int i = 0; i < 1; i++) {
            Player player = new Player();
            player.setName("TEST" + i+6);
            leaguePlayers.add(player);
        }

        try {
            GameService.getInstance().createTournamentStageGames(leaguePlayers, GameType.FINAL);
            resultMsg = "";
        } catch (Exception e) {
            resultMsg = e.getMessage();
        }

        Assertions.assertEquals("", resultMsg);

    }
}
