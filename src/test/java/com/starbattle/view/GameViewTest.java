package com.starbattle.view;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.starbattle.factory.PlayerClass;
import com.starbattle.model.entities.Team;

class GameViewTest {

    private InputStream originalIn;

    @BeforeEach
    void saveSystemIn() {
        originalIn = System.in;
    }

    @AfterEach
    void restoreSystemIn() {
        System.setIn(originalIn);
    }

    @Test
    void lobby_shouldReturnTrueWhenUserChoosesStart() {
        System.setIn(new ByteArrayInputStream("1\n".getBytes()));

        GameView view = new GameView();

        assertTrue(view.lobby(),
                "Lobby deve retornar true quando usuário escolhe iniciar");
    }

    @Test
    void lobby_shouldReturnFalseWhenUserChoosesExit() {
        System.setIn(new ByteArrayInputStream("2\n".getBytes()));

        GameView view = new GameView();

        assertFalse(view.lobby(),
                "Lobby deve retornar false quando usuário escolhe sair");
    }

    @Test
    void requestTeam_shouldReturnValidTeam() {
        System.setIn(new ByteArrayInputStream("light\n".getBytes()));

        GameView view = new GameView();

        Team team = view.requestTeam();

        assertEquals(Team.LIGHT, team);
    }

    @Test
    void requestClass_shouldReturnValidPlayerClass() {
        System.setIn(new ByteArrayInputStream("jedi\n".getBytes()));

        GameView view = new GameView();

        PlayerClass pc = view.requestClass();

        assertEquals(PlayerClass.JEDI, pc);
    }

    @Test
    void skipTurn_shouldReturnCorrectMessage() {
        GameView view = new GameView();

        String msg = view.skipTurn(
                new com.starbattle.model.entities.Clone("Test", Team.DARK)
        );

        assertTrue(msg.contains("Sistema"),
                "Mensagem de pular turno deve conter 'Sistema'");
    }
}