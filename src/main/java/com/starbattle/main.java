package com.starbattle;

import com.starbattle.controller.GameController;

public class Main{
    public static void main(String[] args) {
        GameController controller = new GameController();

        controller.initGame();
    }
}