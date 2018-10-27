package com.mahrous.footballapp.users.service.impl;

import com.mahrous.footballapp.users.mapper.PlayerMapper;
import com.mahrous.footballapp.users.model.entity.Player;
import com.mahrous.footballapp.users.model.repos.PlayerRepo;
import com.mahrous.footballapp.users.payload.request.BasicPlayerRequest;
import com.mahrous.footballapp.users.service.PlayerService;
import com.mahrous.footballapp.users.validator.PlayerValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlayerServiceImpl implements PlayerService {
    private static Logger logger = LoggerFactory.getLogger(PlayerServiceImpl.class);
    private PlayerRepo playerRepo;
    private PlayerMapper playerMapper;
    private PlayerValidator playerValidator;

    @Override
    public boolean create(BasicPlayerRequest basicPlayerRequest) {
        boolean created;


        boolean isValid = playerValidator.validateUniqueness(basicPlayerRequest);
        if (isValid) {
            Player player = playerMapper.basicReqToPlayer(basicPlayerRequest);
            playerRepo.save(player);
            created = true;
        } else {
            logger.error("User name or email already exits");
            created = false;
        }
        return created;
    }

    @Override
    public Player find(String userName) {
        Player player = null;
        try {
            logger.info("Starting Looking for a player with username: {}", userName);
            Optional<Player> optionalPlayer = playerRepo.findByUserName(userName);
            logger.info("Completed finding a player with username: {}", userName);

            if (optionalPlayer.isPresent()) {
                player = optionalPlayer.get();
                logger.info("player : {}", player);
            }
        } catch (Exception e) {
            logger.error("Couldn't find a User with username: {}", userName);
            logger.error("Stack: {}", e);
        }
        return player;
    }

    @Override
    public boolean update(BasicPlayerRequest basicPlayerRequest) {
        boolean updated = false;
        try {
            Player player;
            Optional<Player> optionalPlayer = playerRepo.findByUserName(basicPlayerRequest.getUserName());
            if (optionalPlayer.isPresent()) {
                player = optionalPlayer.get();
                player.setFirstName(basicPlayerRequest.getFirstName());
                player.setEmail(basicPlayerRequest.getEmail());
                player.setLastName(basicPlayerRequest.getLastName());
                player.setPassword(basicPlayerRequest.getPassword());
                player.setPlayerType(basicPlayerRequest.getPlayerType());
                playerRepo.save(player);
                updated = true;
            }

        } catch (Exception e) {
            logger.error("Couldn't find a User with username: {}", basicPlayerRequest.getUserName());
            logger.error("Stack: {}", e);
        }
        return updated;
    }

    @Override
    public boolean delete(String userName) {

        return false;
    }

    @Override
    public boolean usernameExists(String userName) {
        boolean exists;
        exists = playerRepo.existsByUserName(userName);
        return exists;
    }

    @Override
    public boolean emailExists(String email) {
        boolean exists;
        exists = playerRepo.existsByEmail(email);
        return exists;
    }

    @Override
    public boolean exists(String userName, String email) {
        boolean exists;
        exists = playerRepo.existsByUserNameOrEmail(userName, email);
        return exists;
    }

    public PlayerRepo getPlayerRepo() {
        return playerRepo;
    }

    @Autowired
    public void setPlayerRepo(PlayerRepo playerRepo) {
        this.playerRepo = playerRepo;
    }

    public PlayerMapper getPlayerMapper() {
        return playerMapper;
    }

    @Autowired
    public void setPlayerMapper(PlayerMapper playerMapper) {
        this.playerMapper = playerMapper;
    }

    public PlayerValidator getPlayerValidator() {
        return playerValidator;
    }

    @Autowired
    public void setPlayerValidator(PlayerValidator playerValidator) {
        this.playerValidator = playerValidator;
    }
}
