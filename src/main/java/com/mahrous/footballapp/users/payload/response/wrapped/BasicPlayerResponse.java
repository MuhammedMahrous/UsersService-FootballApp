package com.mahrous.footballapp.users.payload.response.wrapped;

import com.mahrous.footballapp.users.payload.response.BasicPlayer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

public class BasicPlayerResponse extends ResponseEntity<BasicPlayer> {

    public BasicPlayerResponse(HttpStatus status) {
        super(status);
    }

    public BasicPlayerResponse(BasicPlayer body, HttpStatus status) {
        super(body, status);
    }

    public BasicPlayerResponse(MultiValueMap<String, String> headers, HttpStatus status) {
        super(headers, status);
    }

    public BasicPlayerResponse(BasicPlayer body, MultiValueMap<String, String> headers, HttpStatus status) {
        super(body, headers, status);
    }
}
