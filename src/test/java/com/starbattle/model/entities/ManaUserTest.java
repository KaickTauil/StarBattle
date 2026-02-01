package com.starbattle.model.entities;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class ManaUserTest {

    @Test
    void hasMana_shouldReturnTrueWhenEnoughMana() {
        ManaUser user = new FakeManaUser(100);

        assertTrue(user.hasMana(50),
                "Deve retornar true quando mana é suficiente");
    }

    @Test
    void hasMana_shouldReturnFalseWhenNotEnoughMana() {
        ManaUser user = new FakeManaUser(30);

        assertFalse(user.hasMana(50),
                "Deve retornar false quando mana é insuficiente");
    }

    // ===== classe fake apenas para teste =====
    private static class FakeManaUser implements ManaUser {

        private float mana;

        FakeManaUser(float mana) {
            this.mana = mana;
        }

        @Override
        public float getmana() {
            return mana;
        }

        @Override
        public void consumeMana(int quantity) {
            mana -= quantity;
        }
    }
}
