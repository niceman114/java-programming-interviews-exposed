package com.wiley.javainterviewsexposed.chapter09.runner;

import org.junit.Test;
import org.junit.runner.Description;
import org.junit.runner.JUnitCore;
import org.junit.runner.Runner;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.model.InitializationError;

import java.lang.reflect.Method;
import java.util.*;

public class RandomizedRunner extends Runner {

    private final Class<?> testClass;
    private final Description description;

    private final Map<String, Method> methodMap;

    public RandomizedRunner(Class<?> testClass)
                            throws InitializationError {

        this.testClass = testClass;
        this.description =
                Description.createSuiteDescription(testClass);

        final List<Method> methodsUnderTest = new ArrayList<>();

        for (Method method : testClass.getMethods()) {
            if (method.isAnnotationPresent(Test.class)) {
                methodsUnderTest.add(method);
            }
        }

        Collections.shuffle(methodsUnderTest);

        methodMap = new HashMap<>();

        for (Method method : methodsUnderTest) {
            description.addChild(Description.createTestDescription(
                    testClass,
                    method.getName())
            );

            System.out.println(method.getName());
            methodMap.put(method.getName(), method);
        }
    }

    @Override
    public Description getDescription() {
        return description;
    }

    @Override
    public void run(RunNotifier runNotifier) {
        runNotifier.fireTestStarted(description);
        for (Description descUnderTest : description.getChildren()) {
            runNotifier.fireTestStarted(descUnderTest);
            try {
                methodMap.get(descUnderTest.getMethodName())
                        .invoke(testClass.newInstance());

                runNotifier.fireTestFinished(descUnderTest);
            } catch (Throwable e) {
                runNotifier.fireTestFailure(
                        new Failure(descUnderTest, e.getCause()));
            }
        }
        runNotifier.fireTestFinished(description);
    }

    public static void main(String[] args) {
        JUnitCore.main(RandomizedRunner.class.getName());
    }
}
