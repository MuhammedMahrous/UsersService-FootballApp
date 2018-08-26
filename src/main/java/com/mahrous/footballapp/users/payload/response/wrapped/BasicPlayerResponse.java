package com.mahrous.footballapp.users.payload.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

public class BasicPlayerResponse extends ResponseEntity<BasicPlayerResponse> {

    public BasicPlayerResponse(HttpStatus status) {
        super(status);
    }

    public BasicPlayerResponse(BasicPlayerResponse body, HttpStatus status) {
        super(body, status);
    }

    public BasicPlayerResponse(MultiValueMap<String, String> headers, HttpStatus status) {
        super(headers, status);
    }

    public BasicPlayerResponse(BasicPlayerResponse body, MultiValueMap<String, String> headers, HttpStatus status) {
        super(body, headers, status);
    }
}
