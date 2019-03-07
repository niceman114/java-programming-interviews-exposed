package com.wiley.javainterviewsexposed.chapter09;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class GameTestWithStub {

    private static class StubHighScoreService
            implements HighScoreService {
        @Override
        public List<String> getTopFivePlayers() {
            return Arrays.asList(
                    "Alice",
                    "Bob",
                    "Charlie",
                    "Dave",
                    "Elizabeth");
        }

        @Override
        public boolean saveHighScore(int score, String playerName) {
            throw new UnsupportedOperationException(
                    "saveHighScore not implemented for this test");
        }
    }

    @Test
    public void highScoreDisplay() {
        final String expectedPlayerList =
                "1. Alice\n" +
                        "2. Bob\n" +
                        "3. Charlie\n" +
                        "4. Dave\n" +
                        "5. Elizabeth\n";

        final HighScoreService stubbedHighScoreService =
                new StubHighScoreService();
        final Game gameUnderTest = new Game(stubbedHighScoreService);

        assertEquals(
                expectedPlayerList,
                gameUnderTest.displayHighScores());
    }

    @Test(timeout = 1000L)
    public void serviceResponseTime() {
        final HighScoreService realHighScoreService = new StubHighScoreService();
//        final HighScoreService realHighScoreService = ...// constructed against a real service
        final Game gameUnderTest = new Game(realHighScoreService);
        final String highScoreDisplay = gameUnderTest.displayHighScores();
        assertNotNull(highScoreDisplay);
    }

    @Test
    public void manualResponseTimeCheck() throws InterruptedException {
        final HighScoreService realHighScoreService =
                new StubHighScoreService();

        final Game gameUnderTest = new Game(realHighScoreService);

        final CountDownLatch latch = new CountDownLatch(1);
        final List<Throwable> exceptions = new ArrayList<>();

        final Runnable highScoreRunnable = new Runnable() {
            @Override
            public void run() {
                final String highScoreDisplay =
                        gameUnderTest.displayHighScores();
                try {
                    assertNotNull(highScoreDisplay);
                } catch (Throwable e) {
                    exceptions.add(e);
                }
                latch.countDown();
            }
        };

        new Thread(highScoreRunnable).start();
        assertTrue(latch.await(1, TimeUnit.SECONDS));

        if(!exceptions.isEmpty()) {
            fail("Exceptions thrown in different thread: " + exceptions);
        }
    }
}
