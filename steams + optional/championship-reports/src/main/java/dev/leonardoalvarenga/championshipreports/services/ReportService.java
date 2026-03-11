package dev.leonardoalvarenga.championshipreports.services;

import dev.leonardoalvarenga.championshipreports.models.Match;

import java.util.List;
import java.util.Optional;

public class ReportService {
    public long countMatchesByTeam(List<Match> matches, String teamName){
        return matches.stream()
                .filter(match -> match.homeTeam().equals(teamName) || match.awayTeam().equals(teamName))
                .count();
    }

    public int calculateTotalChampionshipGoals(List<Match> matches){
        return matches.stream()
                .mapToInt(Match::getTotalGoals)
                .sum();
    }

    public Optional<Match> findFirstMatchByTeam(List<Match> matches, String teamName){
        return matches.stream()
                .filter(match -> match.homeTeam().equals(teamName) || match.awayTeam().equals(teamName))
                .findFirst();
    }
}
