package com.starbattle.model.entities;

import java.util.Random;

public class Clone extends Player{
    private int crit;

    public Clone(String n, Team t){
        super(n, 160,30,70,t);
        this.crit = 45;
    }

    @Override
    public void attack(Player target){
        Random rd = new Random();
        boolean critHit = rd.nextDouble() < 0.35;
        if(critHit){
            double dmg = atk*(1 + crit/100);
            target.recieveAttack(dmg);
        }else{
            target.recieveAttack(atk);
        }
        
    }

    @Override
    public String attackDesc(){
        Random rd = new Random();
        boolean critHit = rd.nextDouble() < 0.35;
        if(critHit){
            return name + ": Headshot.";
        }else{
            return name + ": Na mira.";
        }
    }
}
