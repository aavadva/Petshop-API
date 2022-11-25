package com.example.petshop.service.exception;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@AllArgsConstructor
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class PetNotFoundException extends RuntimeException {

    private String petName;
    private String fieldName;
    private String fieldValue;

    public PetNotFoundException(){

    }

    public String getPetName() {
        return petName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public String getFieldValue() {
        return fieldValue;
    }
}
