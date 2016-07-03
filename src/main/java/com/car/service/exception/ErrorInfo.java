package com.car.service.exception;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ErrorInfo {

    private List<String> errors;

    public ErrorInfo() {
    }

    public ErrorInfo(List<String> errors) {
        this.errors = errors;
    }

    public ErrorInfo(String error) {
        this(Collections.singletonList(error));
    }

    public ErrorInfo(String ... errors) {
        this(Arrays.asList(errors));
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
}