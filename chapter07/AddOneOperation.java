package com.wiley.javainterviewsexposed.chapter07;

public class AddOneOperation implements IntegerOperation {
    @Override
    public Integer performOperation(Integer value) {
        return value + 1;
    }
}
