package com.starbattle.model.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class TeamTest {

    @Test
    void next_shouldReturnDarkWhenCurrentIsLight() {
        assertEquals(Team.DARK, Team.LIGHT.next(),
                "LIGHT.next() deve retornar DARK");
    }

    @Test
    void next_shouldReturnLightWhenCurrentIsDark() {
        assertEquals(Team.LIGHT, Team.DARK.next(),
                "DARK.next() deve retornar LIGHT");
    }

    @Test
    void listTeams_shouldContainAllTeams() {
        String teams = Team.listTeams();

        assertTrue(teams.contains("LIGHT"),
                "Lista deve conter LIGHT");
        assertTrue(teams.contains("DARK"),
                "Lista deve conter DARK");
    }
}