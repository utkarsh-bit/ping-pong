package com.marketpulse.service;

import com.marketpulse.dataobjects.Player;
import com.marketpulse.dataobjects.Referee;
import com.marketpulse.viewobjects.PlayerVo;
import com.marketpulse.viewobjects.RefereeVo;

import java.util.List;

public interface ITournamentService {

    void initiateTournament(List<PlayerVo> players) throws Exception;

    Referee addReferee(RefereeVo referee);

    Player addPlayer(PlayerVo player);
}
