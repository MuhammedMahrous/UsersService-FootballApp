package com.mahrous.footballapp.users.mapper;

import com.mahrous.footballapp.users.model.entity.Player;
import com.mahrous.footballapp.users.payload.request.BasicPlayerRequest;
import com.mahrous.footballapp.users.payload.response.BasicPlayer;
import com.mahrous.footballapp.users.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PlayerMapper {
    private PlayerService playerService;

    public Player basicReqToPlayer(BasicPlayerRequest basicPlayerRequest) {
        Player player = new Player(
                basicPlayerRequest.getFirstName(),
                basicPlayerRequest.getLastName(),
                basicPlayerRequest.getUserName(),
                basicPlayerRequest.getEmail(),
                basicPlayerRequest.getPassword(),
                basicPlayerRequest.getPlayerType()
        );
        return player;
    }

    public PlayerService getPlayerService() {
        return playerService;
    }

    @Autowired
    public void setPlayerService(PlayerService playerService) {
        this.playerService = playerService;
    }

    public BasicPlayer playerToBasicResponse(Player player) {
        BasicPlayer basicPlayer = null;
        if (player != null)
            basicPlayer = new BasicPlayer(player.getFirstName(),
                    player.getLastName(),
                    player.getUserName(),
                    player.getEmail(),
                    player.getPassword(),
                    player.getPlayerType());
        return basicPlayer;
    }
}
