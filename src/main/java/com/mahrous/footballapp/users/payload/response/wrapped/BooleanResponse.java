package com.mahrous.footballapp.users.payload.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

public class BooleanResponse extends ResponseEntity<Boolean> {
    public BooleanResponse(HttpStatus status) {
        super(status);
    }

    public BooleanResponse(Boolean body, HttpStatus status) {
        super(body, status);
    }

    public BooleanResponse(MultiValueMap<String, String> headers, HttpStatus status) {
        super(headers, status);
    }

    public BooleanResponse(Boolean body, MultiValueMap<String, String> headers, HttpStatus status) {
        super(body, headers, status);
    }
}
