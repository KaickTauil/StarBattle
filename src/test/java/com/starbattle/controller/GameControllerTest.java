package com.starbattle.controller;

import com.starbattle.model.game.Arena;
import com.starbattle.view.FakeGameView;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameControllerTest {

    @Test
    void initGame_shouldExitWhenLobbyReturnsFalse() {
        Arena arena = new Arena();
        FakeGameView view = new FakeGameView();

        view.setLobbyResult(false);

        GameController controller = new GameController(arena, view);

        controller.initGame();

        // se chegou aqui sem loop infinito, passou
        assertTrue(true);
    }

    @Test
    void registerPlayer_shouldReturnEXITWhenUserChoosesExit() {
        Arena arena = new Arena();
        FakeGameView view = new FakeGameView();

        view.setSecondMenuResult(3); // EXIT

        GameController controller = new GameController(arena, view);

        RegisterResult result = controller.registerPlayer();

        assertEquals(RegisterResult.EXIT, result);
    }

    @Test
    void registerPlayer_shouldReturnSTARTWhenUserChoosesStart() {
        Arena arena = new Arena();
        FakeGameView view = new FakeGameView();

        view.setSecondMenuResult(2); // START

        GameController controller = new GameController(arena, view);

        RegisterResult result = controller.registerPlayer();

        assertEquals(RegisterResult.START, result);
    }
}
