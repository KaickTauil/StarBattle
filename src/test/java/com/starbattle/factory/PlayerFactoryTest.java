package com.starbattle.factory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import com.starbattle.model.entities.Clone;
import com.starbattle.model.entities.Jedi;
import com.starbattle.model.entities.Player;
import com.starbattle.model.entities.Team;
import com.starbattle.model.entities.Wookie;

class PlayerFactoryTest {

    @Test
    void create_shouldCreateJedi() {
        Player player = PlayerFactory.create(PlayerClass.JEDI, "Luke", Team.LIGHT);

        assertNotNull(player);
        assertInstanceOf(Jedi.class, player);
        assertEquals("Luke", player.getName());
        assertEquals(Team.LIGHT, player.getTeam());
    }

    @Test
    void create_shouldCreateWookie() {
        Player player = PlayerFactory.create(PlayerClass.WOOKIE, "Chewbacca", Team.LIGHT);

        assertNotNull(player);
        assertInstanceOf(Wookie.class, player);
        assertEquals("Chewbacca", player.getName());
        assertEquals(Team.LIGHT, player.getTeam());
    }

    @Test
    void create_shouldCreateClone() {
        Player player = PlayerFactory.create(PlayerClass.CLONE, "Rex", Team.DARK);

        assertNotNull(player);
        assertInstanceOf(Clone.class, player);
        assertEquals("Rex", player.getName());
        assertEquals(Team.DARK, player.getTeam());
    }

    @Test
    void create_shouldThrowExceptionWhenClassIsNull() {
        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class, () ->
                        PlayerFactory.create(null, "Erro", Team.LIGHT)
                );

        assertTrue(exception.getMessage().contains("não existe"));
    }
}