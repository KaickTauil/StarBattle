package com.starbattle.model.entities;

import com.starbattle.model.abilities.ForcePush;

public class Jedi extends Player implements ManaUser{
    private final float maxMana;
    private float mana;

    public Jedi(String n, Team t){
        super(n, 160, 25, 30, t);
        this.maxMana = 200;
        this.mana = maxMana;
        skills.add(new ForcePush());
    }

    @Override
    public float getmana() {
        return mana;
    }

    @Override
    public void attack(Player target){
        target.recieveAttack(atk);
    }

    @Override
    public void consumeMana(int quantity){
        mana -= quantity;
    }

    @Override
    public String attackDesc(){
        return "SISTEMA: O Jedi " + name + "está atacando com seu sabre!";
    }
}