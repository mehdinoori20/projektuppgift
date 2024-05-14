package se.reky.hakan.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GuardTest {
    @Test
    public void testDefaultConstructor() {
        Guard guard = new Guard();

        // Verifierat att standardvärdena är korrekta
        Assertions.assertEquals("Guard", guard.getName());
        Assertions.assertEquals(20, guard.getHp());
        Assertions.assertEquals(20, guard.getDamage());
    }

    @Test
    public void testCustomConstructor() {
        // Här har jag Skapat en vakt med specifika värden
        String name = "Big Guard";
        int hp = 30;
        int damage = 25;
        Guard guard = new Guard(name, hp, damage);

        // Verifierade att vakten egenskaper är satta korrekt
        Assertions.assertEquals(name, guard.getName());
        Assertions.assertEquals(hp, guard.getHp());
        Assertions.assertEquals(damage, guard.getDamage());
    }
}
