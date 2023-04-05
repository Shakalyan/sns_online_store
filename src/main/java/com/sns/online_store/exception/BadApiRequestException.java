package com.sns.online_store.exception;

import org.springframework.http.HttpStatus;

public class BadApiRequestException extends ApiException {

    public BadApiRequestException(String message) {
        super(HttpStatus.BAD_REQUEST, message);
    }

}
