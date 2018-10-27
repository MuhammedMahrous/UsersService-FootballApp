package com.mahrous.footballapp.users.controller.impl;

import com.mahrous.footballapp.users.controller.PlayerController;
import com.mahrous.footballapp.users.mapper.PlayerMapper;
import com.mahrous.footballapp.users.payload.request.BasicPlayerRequest;
import com.mahrous.footballapp.users.payload.response.BasicPlayer;
import com.mahrous.footballapp.users.payload.response.BooleanWithMessage;
import com.mahrous.footballapp.users.payload.response.wrapped.BasicPlayerResponse;
import com.mahrous.footballapp.users.payload.response.wrapped.BooleanResponse;
import com.mahrous.footballapp.users.service.PlayerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@RestController
@RequestMapping("/api/player")
public class PlayerControllerImpl implements PlayerController {
    private static Logger logger = LoggerFactory.getLogger(PlayerController.class);
    private PlayerService playerService;
    private PlayerMapper playerMapper;

    @Autowired
    public void setPlayerService(PlayerService playerService) {
        this.playerService = playerService;
    }


    @Autowired
    public void setPlayerMapper(PlayerMapper playerMapper) {
        this.playerMapper = playerMapper;
    }

    @PostMapping("/create")
    @Override
    public BooleanResponse create(@RequestBody @Valid BasicPlayerRequest basicPlayerRequest) {

        BooleanResponse booleanResponse = null;
        try {
            Boolean created = playerService.create(basicPlayerRequest);
            if (created) {
                booleanResponse = new BooleanResponse(new BooleanWithMessage(created, "Successfully created!"), HttpStatus.CREATED);
                logger.info("Created a player with request: {}", basicPlayerRequest);
            } else {
                booleanResponse = new BooleanResponse(new BooleanWithMessage(created, "Username or email already exists!"), HttpStatus.NOT_ACCEPTABLE);
            }
        } catch (Exception e) {
            logger.error("Error creating a player with request: {}", basicPlayerRequest);
            logger.error("Stack Trace: {}", e);
            booleanResponse = new BooleanResponse(HttpStatus.NO_CONTENT);
        }
        return booleanResponse;
    }

    @GetMapping("/find/{userName}")
    @Override
    public BasicPlayerResponse find(@PathVariable @NotBlank String userName) {
        BasicPlayerResponse basicPlayerResponse;
        try {
            BasicPlayer basicPlayer = playerMapper.playerToBasicResponse(playerService.find(userName));
            if (basicPlayer != null) {
                basicPlayerResponse = new BasicPlayerResponse(basicPlayer, HttpStatus.OK);
            } else {
                basicPlayerResponse = new BasicPlayerResponse(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            logger.error("Error finding user with username :{}", userName);
            logger.error("Stack trace: {}", e);
            basicPlayerResponse = new BasicPlayerResponse(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return basicPlayerResponse;
    }

    @Override
    @PutMapping("/update")
    public BooleanResponse update(@RequestBody BasicPlayerRequest basicPlayerRequest) {
        boolean updated;
        BooleanResponse basicPlayerResponse;
        try {
            updated = playerService.update(basicPlayerRequest);
            if (updated) {
                BooleanWithMessage booleanWithMessage = new BooleanWithMessage();
                booleanWithMessage.setStatus(updated);
                booleanWithMessage.setMsg("Successfully updated player info");
                basicPlayerResponse = new BooleanResponse(booleanWithMessage, HttpStatus.OK);
            } else {
                basicPlayerResponse = new BooleanResponse(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            logger.error("Error updating info for user with username :{}", basicPlayerRequest.getUserName());
            logger.error("Stack trace: {}", e);
            basicPlayerResponse = new BooleanResponse(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return basicPlayerResponse;
    }

}

// TODO: change boilerplate code with AOP