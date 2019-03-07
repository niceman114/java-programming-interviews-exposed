package com.wiley.javainterviewsexposed.chapter07;

public class StringLengthOperation implements GenericOperation<String, Integer> {
    @Override
    public Integer performOperation(String value) {
        return value.length();
    }
}
