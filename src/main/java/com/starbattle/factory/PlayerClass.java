package com.starbattle.factory;

public enum PlayerClass {
    JEDI,
    WOOKIE,
    CLONE;

    public static String listClasses(){
        String txt = "";
        for(PlayerClass c : PlayerClass.values()){
            txt += c.name() +", ";
        }

        return txt;
    }
}
