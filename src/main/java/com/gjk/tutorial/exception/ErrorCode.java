package com.gjk.tutorial.exception;

public enum ErrorCode {

    STUDENT_ID_WITH_NO_DATA_FOUND(404, "Student with this id doesn't exist in DB.");
    private int code;

    private String description;

    private ErrorCode(int code, String description) {
        this.code = code;
        this.description = description;
    }

    private ErrorCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
