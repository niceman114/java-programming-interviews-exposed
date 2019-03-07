package com.wiley.javainterviewsexposed.chapter09;

import org.junit.Test;

import static org.junit.Assert.fail;

public class ExplicitExceptions {

    @Test
    public void testExceptionThrowingMethod() {
        final String validString = "ValidString";
        final String emptyValidString = "";
        final String invalidString = null;

        ParameterVerifications.checkString(validString);
        ParameterVerifications.checkString(emptyValidString);
        try {
            ParameterVerifications.checkString(invalidString);
            fail("Validation should throw exception for null String");
        } catch (ParameterVerificationException e) {
            // test passed
        }
    }

}

class ParameterVerifications {
    public static void checkString(String param) {
        if (param == null) throw new ParameterVerificationException("String parameter cannot be null");
    }
}

class ParameterVerificationException extends RuntimeException {
    ParameterVerificationException(String message, Throwable cause) {
        super(message, cause);
    }

    ParameterVerificationException(String message) {
        super(message);
    }
}