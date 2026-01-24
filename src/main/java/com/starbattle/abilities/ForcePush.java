package com.starbattle.abilities;

import com.starbattle.entities.ManaUser;
import com.starbattle.entities.Player;

public class ForcePush implements SpecialSkill{
    private final int manaCost = 20;
    
    @Override
    public String getNome(){
        return "force push";
    }

    @Override
    public void execute(Player user, Player target){
        if(!(user instanceof ManaUser manaUser)){
            System.out.println("O combatente tem que ser um usuário de mana para usar isso !");

        }else if(!manaUser.hasMana(manaCost)){
            System.out.println("Você não tem mana o suficiente!");
            
        }else{
            double finalDmg = user.getAtk() * 2.5;
            System.out.println("Force push !!!!\n==Force push dealed "+finalDmg+" damage!==");
            target.recieveAttack(finalDmg);
        }
        
    }
}
