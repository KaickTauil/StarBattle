package com.starbattle.model.entities;

public class Wookie extends Player{
    private final int maxVim;
    private int vim;

    public Wookie(String n, Team t){
        super(n, 250, 50, 20, t);
        this.maxVim = 100;
        vim = maxVim;
    }

    @Override
    public void attack(Player target){
        target.recieveAttack(atk);
    }

    @Override
    public void recieveAttack(double dam){
        double finalDam = (dam * (1 - def/100));

        if(finalDam > 0){
            if((clife -= finalDam) <= (this.getClife()*(1-10/100))){
                clife += vim;
                vim = 0;
            }
            clife -= finalDam;
        }
    }

    @Override
    public String attackDesc(){
        return name + ": HWAAAAAARR";
    }

    @Override
    public String damageDesc(double dam){
        double finalDam = dam * (1 - def/100);

        if(finalDam > 0){
            return name + ": HWOOOORRRRRR";
        }else{
            return name +": Hwar??";
        }
    }
}
