package com.marketpulse.service;

import com.marketpulse.dataobjects.Game;
import com.marketpulse.dataobjects.Player;
import com.marketpulse.dataobjects.Referee;
import com.marketpulse.viewobjects.RefereeVo;

import java.util.List;

public interface IRefereeService {

    Referee createReferee(RefereeVo refereeVo);

    List<Game> createTournamentGames(List<Player> players);
}
