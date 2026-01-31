package com.starbattle.model.abilities;

import com.starbattle.model.entities.Player;

public interface SpecialSkill {
    String getName();

    void execute(Player user, Player target);

    String skillDesc(Player user, double dmg);
}
