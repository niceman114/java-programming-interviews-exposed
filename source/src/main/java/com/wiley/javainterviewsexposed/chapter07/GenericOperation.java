package com.wiley.javainterviewsexposed.chapter07;

public interface GenericOperation<A, B> {
    B performOperation(A value);
}
