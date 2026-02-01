package com.starbattle.view;

import com.starbattle.factory.PlayerClass;
import com.starbattle.model.entities.Player;
import com.starbattle.model.entities.Team;

public class FakeGameView extends GameView {

    private boolean lobbyResult = false;
    private int secondMenuResult = 3;

    public void setLobbyResult(boolean value) {
        this.lobbyResult = value;
    }

    public void setSecondMenuResult(int value) {
        this.secondMenuResult = value;
    }

    @Override
    public boolean lobby() {
        return lobbyResult;
    }

    @Override
    public void goodbyeMessage() {
        // não faz nada
    }

    @Override
    public String requestName() {
        return "TestPlayer";
    }

    @Override
    public Team requestTeam() {
        return Team.LIGHT;
    }

    @Override
    public PlayerClass requestClass() {
        return PlayerClass.JEDI; // classe real
    }

    @Override
    public int secondMenu() {
        return secondMenuResult;
    }

    @Override
    public int getAction(Player p, Player t) {
        return 1;
    }
}
