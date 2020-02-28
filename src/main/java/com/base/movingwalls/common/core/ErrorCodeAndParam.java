package com.base.movingwalls.common.core;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.http.HttpStatus;

import java.util.Arrays;

@SuppressWarnings("OverloadedVarargsMethod")
public class ErrorCodeAndParam {

    private final String errorCode;
    private final String[] params;
    @JsonIgnore
    private final HttpStatus httpStatus;
    @JsonIgnore
    private final StackTraceElement[] stackTrace;


    public ErrorCodeAndParam(final ErrorCode errorCode, final String... params) {
        this.errorCode = errorCode.getStatus();
        this.params = params;
        this.httpStatus = errorCode.getHttpStatus();
        StackTraceElement[] stackTraceElement = Thread.currentThread().getStackTrace();
        this.stackTrace = Arrays.copyOfRange(stackTraceElement, 2, stackTraceElement.length - 1);
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String[] getParams() {
        return params;
    }

    public StackTraceElement[] getStackTrace() {
        return stackTrace;
    }
}
