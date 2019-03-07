package com.wiley.javainterviewsexposed.chapter16.mvc;

import org.junit.Test;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class ResultsControllerTest {

    @Test
    public void specificTeamResults() throws Exception {
        final SportsResultsService mockService = mock(SportsResultsService.class);

        final List<Result> results = Arrays.asList(
                new Result("Home", "Away", 1, 2),
                new Result("IgnoreHome1", "IgnoreAway1", 0, 0)
        );

        when(mockService.getMostRecentResults()).thenReturn(results);

        final List<Result> expectedResults = Arrays.asList(new Result("Home", "Away", 1, 2));

        final ResultsController controller = new ResultsController(mockService);
        final Model model = new ExtendedModelMap();

        controller.getMostRecentResultsForTeam("Home", model);

        assertEquals(expectedResults, model.asMap().get("results"));
    }
}
