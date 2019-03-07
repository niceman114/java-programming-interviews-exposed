package com.wiley.javainterviewsexposed.chapter16.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/results")
public class ResultsController {

    private final SportsResultsService resultsService;

    @Autowired
    public ResultsController(final SportsResultsService resultsService) {
        this.resultsService = resultsService;
    }

    @RequestMapping(value = "/recent")
    public String getMostRecentResults(final Model model) {
        model.addAttribute("results", resultsService.getMostRecentResults());
        return "resultsView";
    }

    @RequestMapping("/recent/{team}")
    public String getMostRecentResultsForTeam(
            @PathVariable("team") final String team,
            final Model model) {
        final List<Result> results = resultsService.getMostRecentResults();
        final List<Result> resultsForTeam = new ArrayList<Result>();
        for (Result result : results) {
            if (Arrays.asList(
                    result.getHomeTeam(),
                    result.getHomeTeam()
               ).contains(team)) {
                resultsForTeam.add(result);
            }
        }

        if (resultsForTeam.isEmpty()) {
            return "teamNotFound";
        } else {
            model.addAttribute("results", resultsForTeam);
            return "resultsView";
        }
    }

}
