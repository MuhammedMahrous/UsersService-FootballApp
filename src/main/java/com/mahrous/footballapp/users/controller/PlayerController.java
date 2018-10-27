package com.mahrous.footballapp.users.controller;

import com.mahrous.footballapp.users.payload.request.BasicPlayerRequest;
import com.mahrous.footballapp.users.payload.response.wrapped.BasicPlayerResponse;
import com.mahrous.footballapp.users.payload.response.wrapped.BooleanResponse;

public interface PlayerController {
    BooleanResponse create(BasicPlayerRequest basicPlayerRequest);

    BasicPlayerResponse find(String userName);

    BooleanResponse update(BasicPlayerRequest basicPlayerRequest);
}
