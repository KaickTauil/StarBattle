package com.starbattle.model.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CloneTest {

    private Clone clone;
    private Player target;

    @BeforeEach
    void setup() {
        clone = new Clone("CT-99", Team.LIGHT);
        target = new Clone("Alvo", Team.DARK);
    }

    @Test
    void attack_shouldReduceTargetLife() {
        int lifeBefore = target.getClife();

        clone.attack(target);

        int lifeAfter = target.getClife();

        assertTrue(lifeAfter < lifeBefore,
                "O ataque do Clone deve reduzir a vida do alvo");
    }

    @Test
    void attackDesc_shouldReturnValidMessage() {
        String desc = clone.attackDesc();

        assertTrue(
            desc.equals("CT-99: Headshot.") ||
            desc.equals("CT-99: Na mira."),
            "Descrição do ataque deve ser uma das mensagens esperadas");
    }

    @Test
    void clone_shouldStartAlive() {
        assertTrue(clone.isAlive(), "Clone deve iniciar vivo");
    }

    @Test
    void clone_shouldHaveCorrectTeam() {
        assertEquals(Team.LIGHT, clone.getTeam());
    }
}