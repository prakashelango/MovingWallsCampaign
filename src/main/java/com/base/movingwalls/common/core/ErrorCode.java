package com.base.movingwalls.common.core;

import org.springframework.http.HttpStatus;

public enum ErrorCode {


    NOT_FOUND("MWLS_0001", HttpStatus.NOT_FOUND),
    FILE_WRITING_FAILED("MWLS_0002", HttpStatus.INTERNAL_SERVER_ERROR),
    DOC_FILE_SEQUENCE("MWLS_0003", HttpStatus.BAD_REQUEST);

    private final String status;
    private final HttpStatus httpStatus;

    ErrorCode(final String status, final HttpStatus httpStatus) {
        this.status = status;
        this.httpStatus = httpStatus;
    }

    public String getStatus() {
        return status;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
