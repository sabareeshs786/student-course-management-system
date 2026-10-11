package com.airtribe.learntrack.util;

import com.airtribe.learntrack.exception.InvalidInputException;

public class InputValidator {

    public static void validateNonEmpty(String value, String fieldName) throws InvalidInputException {
        if(value == null || value.trim().isEmpty()){
            throw new InvalidInputException(fieldName + " must not be empty");
        }
    }

    public static void validatePositive(int value, String fieldName) throws InvalidInputException {
        if(value <= 0){
            throw new InvalidInputException(fieldName + " must be a positive number");
        }
    }
}
