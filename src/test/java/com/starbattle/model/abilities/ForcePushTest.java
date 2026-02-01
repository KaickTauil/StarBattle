package com.starbattle.model.abilities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.starbattle.model.entities.Jedi;
import com.starbattle.model.entities.Team;
import com.starbattle.model.entities.Wookie;

class ForcePushTest {

    private ForcePush forcePush;
    private Jedi jedi;
    private Wookie target;

    @BeforeEach
    void setup() {
        forcePush = new ForcePush();
        jedi = new Jedi("Luke", Team.LIGHT);
        target = new Wookie("Chewie", Team.DARK);
    }

    @Test
    void execute_shouldDealDamageAndConsumeMana() {
        int lifeBefore = target.getClife();
        float manaBefore = jedi.getmana();

        forcePush.execute(jedi, target);

        assertTrue(target.getClife() < lifeBefore, "Deveria causar dano no alvo");
        assertEquals(manaBefore - forcePush.getManaCost(), jedi.getmana(), "Deveria consumir mana");
    }

    @Test
    void execute_shouldNotWorkIfUserIsNotManaUser() {
        Wookie attacker = new Wookie("Attacker", Team.LIGHT);
        int lifeBefore = target.getClife();

        forcePush.execute(attacker, target);

        assertEquals(lifeBefore, target.getClife(), "Não deveria causar dano");
    }

    @Test
    void getName_shouldReturnForcePush() {
        assertEquals("force push", forcePush.getName());
    }

    @Test
    void getManaCost_shouldReturn20() {
        assertEquals(20, forcePush.getManaCost());
    }

    @Test
    void getDamage_shouldMatchCalculatedDamage() {
        double expected = jedi.getAtk() * 2.5;
        assertEquals(expected, forcePush.getDamage(jedi));
    }
}