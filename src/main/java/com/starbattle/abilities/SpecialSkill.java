package com.starbattle.abilities;

import com.starbattle.entities.Player;

public interface SpecialSkill {
    String getName();

    void execute(Player user, Player target);
}
