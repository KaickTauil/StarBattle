package com.starbattle.entities;

import java.util.Random;

public class Clone extends Player{
    private int crit;

    public Clone(String n, String t){
        super(n, 160,30,70,t);
        this.crit = 45;
    }

    @Override
    public void attack(Player target){
        System.out.println("Na mira.");

        Random rd = new Random();
        boolean critHit = rd.nextDouble() < 0.35;
        if(critHit){
            double dmg = atk*(1 + crit/100);
            System.out.println("Headshot.\n===O clone "+this.getName()+" causou um golpe crítico de "+dmg+" de dano!===");
            target.recieveAttack(dmg);
        }else{
            target.recieveAttack(atk);
        }
        
    }
}
