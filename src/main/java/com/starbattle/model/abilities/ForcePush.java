package com.starbattle.model.abilities;

import com.starbattle.model.entities.ManaUser;
import com.starbattle.model.entities.Player;

public class ForcePush implements SpecialSkill{
    private final int manaCost = 20;
    
    @Override
    public String getName(){
        return "force push";
    }

    @Override
    public void execute(Player user, Player target){
        if(user instanceof ManaUser manaUser && manaUser.hasMana(manaCost)){
            double finalDmg = user.getAtk() * 2.5;
            target.recieveAttack(finalDmg);
            manaUser.consumeMana(manaCost);
        }
    }

    @Override
    public String skillDesc(Player user, double dmg){
        return user.getName() + ": Force push !!!!\n==SISTEMA: Force push causou "+ dmg +" de dano!==";
    }
}
