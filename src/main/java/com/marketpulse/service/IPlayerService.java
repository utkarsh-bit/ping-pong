package com.marketpulse.service;

import com.marketpulse.dataobjects.Player;
import com.marketpulse.viewobjects.PlayerVo;

public interface IPlayerService {

    Player createPlayer(PlayerVo playerVo);
}
