package com.starbattle.factory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class PlayerClassTest {

    @Test
    void listClasses_shouldReturnAllPlayerClasses() {
        String result = PlayerClass.listClasses();

        assertTrue(result.contains("JEDI"));
        assertTrue(result.contains("WOOKIE"));
        assertTrue(result.contains("CLONE"));
    }

    @Test
    void listClasses_shouldNotReturnNullOrEmpty() {
        String result = PlayerClass.listClasses();

        assertNotNull(result);
        assertFalse(result.isBlank());
    }

    @Test
    void listClasses_shouldReturnExpectedFormat() {
        String result = PlayerClass.listClasses();

        assertEquals("JEDI, WOOKIE, CLONE, ", result);
    }
}
