package com.starbattle.entities;

public interface ManaUser {
    float getmana();

    void consumeMana(int quantity);

    default boolean hasMana(int quantity){
        return getmana() >= 0;
    }
}
