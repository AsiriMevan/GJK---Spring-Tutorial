package com.gjk.tutorial.exception;

public class GjKException extends Exception {

    private static final long serialVersionUID = 1L;

    private final ErrorCode errorCode;
    private final String message;

    public GjKException(ErrorCode errorCode) {
        this.errorCode = errorCode;
        this.message = errorCode.getDescription();
    }

    public GjKException(ErrorCode errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    @Override
    public String getMessage() {
        return message;
    }


}
