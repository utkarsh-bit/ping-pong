package com.marketpulse.service;

import com.marketpulse.dataobjects.abstraction.Participants;
import com.marketpulse.viewobjects.PlayerVo;
import com.marketpulse.viewobjects.RefereeVo;

import java.util.List;

public interface ITournamentService {

    void initiateTournament(List<PlayerVo> playerVo, RefereeVo refereeVo) throws Exception;
}
