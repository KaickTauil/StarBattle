package com.starbattle.model.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.starbattle.model.abilities.SpecialSkill;

class PlayerTest {

    private Player player;
    private Player target;

    @BeforeEach
    void setup() {
        player = new TestPlayer("Tester", Team.LIGHT);
        target = new TestPlayer("Target", Team.DARK);
    }

    @Test
    void player_shouldStartWithFullLife() {
        assertEquals(100, player.getClife(),
                "Player deve iniciar com vida cheia");
    }

    @Test
    void recieveAttack_shouldReduceLifeConsideringDefense() {
        int lifeBefore = player.getClife();

        player.recieveAttack(50);

        assertTrue(player.getClife() < lifeBefore,
                "Ataque deve reduzir a vida considerando defesa");
    }

    @Test
    void recieveAttack_shouldNotReduceLifeWhenFinalDamageIsZero() {
        int lifeBefore = player.getClife();

        player.recieveAttack(0);

        assertEquals(lifeBefore, player.getClife(),
                "Vida não deve mudar se dano final for zero");
    }

    @Test
    void isAlive_shouldReturnTrueWhenLifeAboveZero() {
        assertTrue(player.isAlive());
    }

    @Test
    void hasSkill_shouldReturnFalseWhenNoSkills() {
        assertFalse(player.hasSkill(),
                "Player sem skills deve retornar false");
    }

    @Test
    void useSkill_shouldExecuteSkill() {
        FakeSkill skill = new FakeSkill();
        player.getSkills().add(skill);

        player.useSkill(target, 0);

        assertTrue(skill.executed,
                "Skill deve ser executada ao usar");
    }

    // ===== Player concreto apenas para testes =====
    private static class TestPlayer extends Player {

        TestPlayer(String name, Team team) {
            super(name, 100, 20, 30, team);
        }

        @Override
        public void attack(Player target) {
            target.recieveAttack(atk);
        }
    }

    // ===== Skill fake =====
    private static class FakeSkill implements SpecialSkill {

        boolean executed = false;

        @Override
        public String getName() {
            return "FakeSkill";
        }

        @Override
        public void execute(Player user, Player target) {
            executed = true;
        }

        @Override
        public String skillDesc(Player user, double dmg) {
            return "";
        }

        @Override
        public double getDamage(Player p) {
            return 0;
        }

        @Override
        public int getManaCost() {
            return 0;
        }
    }
}