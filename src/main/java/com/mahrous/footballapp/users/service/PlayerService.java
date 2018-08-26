package com.mahrous.footballapp.users.service;

import com.mahrous.footballapp.users.model.entity.Player;
import com.mahrous.footballapp.users.payload.request.BasicPlayerRequest;

public interface PlayerService {
    boolean create(BasicPlayerRequest basicPlayerRequest);

    Player find(String userName);

    boolean update(BasicPlayerRequest basicPlayerRequest);

    boolean delete(String userName);

    boolean usernameExists(String userName);

    boolean emailExists(String email);

    boolean exists(String userName, String email);
}
