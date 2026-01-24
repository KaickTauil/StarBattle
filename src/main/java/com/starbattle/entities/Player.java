package com.starbattle.entities;

import com.starbattle.abilities.SpecialSkill;
import java.util.ArrayList;
import java.util.List;

public abstract class Player{
    protected String name;
    protected final int mlife;
    protected int clife;
    protected int def;
    protected int atk;
    protected final String team;
    protected List<SpecialSkill> skills =  new ArrayList<>();


    public Player(String n, int l, int de, int at, String t){
        this.name = n;
        this.mlife = l;
        this.def = de;
        this.atk = at;
        this.team = t;
        this.clife = mlife;
    }

    public String getName(){
        return name;
    }

    public int getAtk(){
        return atk;
    }

    public int getClife(){
        return clife;
    }

    public abstract void attack(Player target);

    public void recieveAttack(double  dam){
        double finalDam = dam * (1 - def/100);

        if(finalDam > 0){
            clife -= finalDam;
            System.out.println("Ouch");
        }else{
            System.out.println("O que foi esse vento?");
        }
    }

    public void useSkill(int skillIdx, Player target){
        SpecialSkill skill = skills.get(skillIdx);
        skill.execute(this, target);
    }
}