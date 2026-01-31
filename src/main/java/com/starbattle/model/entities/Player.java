package com.starbattle.model.entities;

import com.starbattle.model.abilities.SpecialSkill;
import java.util.ArrayList;
import java.util.List;

public abstract class Player{
    protected String name;
    protected final int mlife;
    protected int clife;
    protected int def;
    protected int atk;
    protected Team team;
    protected List<SpecialSkill> skills =  new ArrayList<>();


    public Player(String n, int l, int de, int at, Team t){
        this.name = n;
        this.mlife = l;
        this.def = de;
        this.atk = at;
        this.team = t;
        this.clife = mlife;
    }

    public void setName(String n){
        this.name = n;
    }

    public void setTeam(Team t){
        this.team = t;
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

    public Team getTeam(){
        return team;
    }

    public boolean hasSkill(){
        return !skills.isEmpty();
    }

    public List<SpecialSkill> getSkills(){
        return skills;
    }

    public boolean isAlive(){
        return clife > 0;
    }

    public abstract void attack(Player target);

    public void recieveAttack(double  dam){
        double finalDam = dam * (1 - def/100);

        if(finalDam > 0){
            clife -= finalDam;
        }
    }

    public void useSkill(Player target, int i){
        SpecialSkill skill = skills.get(i);
        skill.execute(this, target);
    }

    public String attackDesc(){
        return "Sistema: " + name + " esta atacando!";
    }

    public String damageDesc(double dam){
        double finalDam = dam * (1 - def/100);

        if(finalDam > 0){
            return name + ": Ouch";
        }else{
            return name +": O que foi esse vento?";
        }
    }

}