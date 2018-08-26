package com.mahrous.footballapp.users.payload.response.wrapped;

import com.mahrous.footballapp.users.payload.response.BooleanWithMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

public class BooleanResponse extends ResponseEntity<BooleanWithMessage> {
    public BooleanResponse(HttpStatus status) {
        super(status);
    }

    public BooleanResponse(BooleanWithMessage body, HttpStatus status) {
        super(body, status);
    }

    public BooleanResponse(MultiValueMap<String, String> headers, HttpStatus status) {
        super(headers, status);
    }

    public BooleanResponse(BooleanWithMessage body, MultiValueMap<String, String> headers, HttpStatus status) {
        super(body, headers, status);
    }
}
