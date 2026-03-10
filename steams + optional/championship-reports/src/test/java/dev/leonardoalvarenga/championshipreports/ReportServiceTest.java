package dev.leonardoalvarenga.championshipreports;

import dev.leonardoalvarenga.championshipreports.models.Match;
import dev.leonardoalvarenga.championshipreports.services.ReportService;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReportServiceTest {
    @Test
    public void shouldReturnNumberOfMatches(){
        ReportService service = new ReportService();

        List<Match> matches = new ArrayList<>();

        Match m1 = new Match("Bayern de Munique", "Atalanta", 3, 0, LocalDate.of(2026, 3, 10));
        Match m2 = new Match("Newcastle", "Barcelona", 1, 2, LocalDate.of(2026, 3, 10));

        matches.add(m1);
        matches.add(m2);

        assertEquals(1, service.countMatchesByTeam(matches, "Bayern de Munique"));

    }
}
