package com.starbattle.entities;

import com.starbattle.abilities.SpecialSkill;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Player{
    protected String name;
    protected final int mlife;
    protected int clife;
    protected int def;
    protected int atk;
    protected final Team team;
    protected List<SpecialSkill> skills =  new ArrayList<>();


    public Player(String n, int l, int de, int at, Team t){
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

    public Team getTeam(){
        return team;
    }

    public boolean hasSkill(){
        return !skills.isEmpty();
    }

    public boolean isAlive(){
        return clife > 0;
    }

    public abstract void attack(Player target);

    public void recieveAttack(double  dam){
        double finalDam = dam * (1 - def/100);

        if(finalDam > 0){
            clife -= finalDam;
            System.out.println(name + ": Ouch");
        }else{
            System.out.println(name +": O que foi esse vento?");
        }
    }

    public void useSkill(Player target){

        String txt = "";
        Scanner input = new Scanner(System.in);
        for(SpecialSkill s : skills){
            int i = 1;
            txt = i + "- " + s.getName() + "\n";
        }
        System.out.println("Selecione a skill que deseja usar: \n"+txt);
        int i = input.nextInt();

        SpecialSkill skill = skills.get(i-1);
        skill.execute(this, target);
    }
}