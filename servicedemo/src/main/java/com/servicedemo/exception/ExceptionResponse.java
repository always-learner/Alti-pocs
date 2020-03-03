package com.servicedemo.exception;

import java.util.Date;

/**
 * Created by ssharma6757 on 10/3/2019.
 */
public class ExceptionResponse {

    private final Date timestamp;
    private final String message;
    private final String detail;

    public ExceptionResponse(final Date timestamp, final String message, final String detail) {
        this.timestamp = timestamp;
        this.message = message;
        this.detail = detail;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetail() {
        return detail;
    }
}
