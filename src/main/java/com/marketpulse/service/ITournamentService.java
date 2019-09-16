package com.marketpulse.service;

import com.marketpulse.dataobjects.abstraction.Participants;

import java.util.List;

public interface ITournamentService {

    void initiateTournament(List<Participants> participants) throws Exception;
}
