package com.mahrous.footballapp.users.validator;

import com.mahrous.footballapp.users.payload.request.BasicPlayerRequest;
import com.mahrous.footballapp.users.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PlayerValidator {

    private PlayerService playerService;

    public boolean validateUniqueness(BasicPlayerRequest basicPlayerRequest) {
        return !playerService.exists(basicPlayerRequest.getUserName(),basicPlayerRequest.getEmail());
    }

    public PlayerService getPlayerService() {
        return playerService;
    }

    @Autowired
    public void setPlayerService(PlayerService playerService) {
        this.playerService = playerService;
    }
}
