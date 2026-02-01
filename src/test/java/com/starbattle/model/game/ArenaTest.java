package com.starbattle.model.game;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.starbattle.model.entities.Clone;
import com.starbattle.model.entities.Jedi;
import com.starbattle.model.entities.Player;
import com.starbattle.model.entities.Team;

class ArenaTest {

    private Arena arena;
    private Player lightPlayer;
    private Player darkPlayer;

    @BeforeEach
    void setup() {
        arena = new Arena();
        lightPlayer = new Jedi("Luke", Team.LIGHT);
        darkPlayer = new Clone("Vader", Team.DARK);
    }

    @Test
    void arena_shouldStartAtRoundOne() {
        assertEquals(1, arena.getRound(),
                "Arena deve iniciar no round 1");
    }

    @Test
    void addPlayer_shouldAddPlayerToCorrectTeam() {
        arena.addPlayer(lightPlayer, Team.LIGHT);

        assertEquals(1, arena.getPlayers(Team.LIGHT).size());
        assertTrue(arena.getPlayers(Team.LIGHT).contains(lightPlayer));
    }

    @Test
    void playersAlive_shouldCountOnlyAlivePlayers() {
        arena.addPlayer(lightPlayer, Team.LIGHT);

        assertEquals(1, arena.playersAlive(Team.LIGHT));
    }

    @Test
    void matchOngoing_shouldReturnTrueWhenBothTeamsHaveAlivePlayers() {
        arena.addPlayer(lightPlayer, Team.LIGHT);
        arena.addPlayer(darkPlayer, Team.DARK);

        assertTrue(arena.matchOngoing(),
                "Partida deve continuar quando ambos os times têm jogadores vivos");
    }

    @Test
    void matchOngoing_shouldReturnFalseWhenOneTeamIsEmpty() {
        arena.addPlayer(lightPlayer, Team.LIGHT);

        assertFalse(arena.matchOngoing(),
                "Partida não deve continuar se um time não tem jogadores");
    }

    @Test
    void nextRound_shouldIncrementRound() {
        int currentRound = arena.getRound();

        arena.nextRound();

        assertEquals(currentRound + 1, arena.getRound());
    }

    @Test
    void winner_shouldReturnDarkWhenLightTeamIsDead() {
        arena.addPlayer(lightPlayer, Team.LIGHT);
        arena.addPlayer(darkPlayer, Team.DARK);

        // mata o jogador LIGHT
        lightPlayer.recieveAttack(10_000);

        assertEquals(Team.DARK, arena.winner(),
                "Time DARK deve vencer quando LIGHT não tem vivos");
    }

    @Test
    void getTarget_shouldReturnEnemyPlayer() {
        arena.addPlayer(lightPlayer, Team.LIGHT);
        arena.addPlayer(darkPlayer, Team.DARK);

        Player target = arena.getTarget(Team.LIGHT);

        assertEquals(Team.DARK, target.getTeam(),
                "Alvo de LIGHT deve ser do time DARK");
    }
}
