package com.wiley.javainterviewsexposed.chapter16.mvc;

import java.util.Arrays;
import java.util.List;

public class DummySportsResultsService implements SportsResultsService {
    @Override
    public List<Result> getMostRecentResults() {
        return Arrays.asList(
                new Result("TeamA", "TeamB", 1, 0),
                new Result("TeamC", "TeamD", 0, 2)
        );
    }
}
