package com.starbattle.model.entities;

public enum Team {
    LIGHT,
    DARK;

    public Team next(){
        return values()[(ordinal() + 1) % values().length];
    }
}
