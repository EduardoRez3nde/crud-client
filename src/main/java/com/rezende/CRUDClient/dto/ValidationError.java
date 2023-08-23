package com.rezende.CRUDClient.dto;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ValidationError extends ExceptionError{

    List<FieldMessage> errors = new ArrayList<>();

    public ValidationError(Instant timeStamp, Integer status, String error, String path) {
        super(timeStamp, status, error, path);
    }

    public List<FieldMessage> getErrors() {
        return errors;
    }

    public void addError(String fieldName, String message){
        errors.add(new FieldMessage(fieldName, message));
    }
}
