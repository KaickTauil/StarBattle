package com.starbattle.model.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class JediTest {

    private Jedi jedi;
    private Player target;

    @BeforeEach
    void setup() {
        jedi = new Jedi("Obi-Wan", Team.LIGHT);
        target = new Clone("Droid", Team.DARK);
    }

    @Test
    void jedi_shouldStartWithFullMana() {
        assertEquals(200, jedi.getmana(),
                "Jedi deve iniciar com mana máxima");
    }

    @Test
    void attack_shouldReduceTargetLife() {
        int lifeBefore = target.getClife();

        jedi.attack(target);

        assertTrue(target.getClife() < lifeBefore,
                "Ataque do Jedi deve reduzir a vida do alvo");
    }

    @Test
    void jedi_shouldHaveSkill() {
        assertTrue(jedi.hasSkill(),
                "Jedi deve iniciar com pelo menos uma skill");
    }

    @Test
    void useSkill_shouldConsumeMana() {
        int manaBefore = (int) jedi.getmana();

        jedi.useSkill(target, 0);

        assertTrue(jedi.getmana() < manaBefore,
                "Usar skill deve consumir mana");
    }

    @Test
    void useSkill_shouldDamageTarget() {
        int lifeBefore = target.getClife();

        jedi.useSkill(target, 0);

        assertTrue(target.getClife() < lifeBefore,
                "Skill do Jedi deve causar dano no alvo");
    }

    @Test
    void consumeMana_shouldReduceMana() {
        jedi.consumeMana(50);

        assertEquals(150, jedi.getmana(),
                "Mana deve ser reduzida corretamente");
    }
}