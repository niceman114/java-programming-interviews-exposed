package com.wiley.javainterviewsexposed.chapter16.mvc;

public class Result {

    private final String homeTeam;
    private final String awayTeam;

    private final int homeTeamScore;
    private final int awayTeamScore;

    public Result(final String homeTeam, final String awayTeam, final int homeTeamScore, final int awayTeamScore) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeTeamScore = homeTeamScore;
        this.awayTeamScore = awayTeamScore;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public int getHomeTeamScore() {
        return homeTeamScore;
    }

    public int getAwayTeamScore() {
        return awayTeamScore;
    }

    @Override
    public String toString() {
        return String.format("%s %d-%d %s", homeTeam, homeTeamScore, awayTeamScore, awayTeam);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Result result = (Result) o;

        if (awayTeamScore != result.awayTeamScore) return false;
        if (homeTeamScore != result.homeTeamScore) return false;
        if (!awayTeam.equals(result.awayTeam)) return false;
        if (!homeTeam.equals(result.homeTeam)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = homeTeam.hashCode();
        result = 31 * result + awayTeam.hashCode();
        result = 31 * result + homeTeamScore;
        result = 31 * result + awayTeamScore;
        return result;
    }
}
