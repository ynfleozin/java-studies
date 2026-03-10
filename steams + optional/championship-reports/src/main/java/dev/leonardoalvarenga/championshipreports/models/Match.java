package dev.leonardoalvarenga.championshipreports.models;

import java.time.LocalDate;

public record Match(
        String homeTeam,
        String awayTeam,
        int homeGoals,
        int awayGoals,
        LocalDate matchDate
) {
    public int getTotalGoals(){
        return homeGoals + awayGoals;
    }
}
