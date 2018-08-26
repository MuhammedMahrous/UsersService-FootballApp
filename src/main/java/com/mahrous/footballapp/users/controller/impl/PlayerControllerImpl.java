package com.mahrous.footballapp.users.controller;

import com.mahrous.footballapp.users.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlayerControllerImpl implements PlayerController {
    private PlayerService playerService;

    public PlayerService getPlayerService() {
        return playerService;
    }

    @Autowired
    public void setPlayerService(PlayerService playerService) {
        this.playerService = playerService;
    }
}
