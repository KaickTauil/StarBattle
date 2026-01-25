package com.starbattle.entities;

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
        System.out.println("HWAAAAAARR");
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
            System.out.println("HWOOOORRRRRR");
        }else{
            System.out.println("Hwar?");
        }
    }
}
