package se.reky.hakan.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GoblinTest {
    @Test
    public void testDefaultConstructor() {
        Goblin goblin = new Goblin();

        // Här Verifierat jag att standardvärdena är korrekta
        Assertions.assertEquals("Goblin", goblin.getName());
        Assertions.assertEquals(20, goblin.getHp());
        Assertions.assertEquals(3, goblin.getDamage());
    }

    @Test
    public void testCustomConstructor() {
        // Här har jag Skapat en goblin med specifika värden
        String name = "Big Goblin";
        int hp = 30;
        int damage = 5;
        Goblin goblin = new Goblin(name, hp, damage);

        // Här har jag Verifierat att goblinens egenskaper är satta korrekt
        Assertions.assertEquals(name, goblin.getName());
        Assertions.assertEquals(hp, goblin.getHp());
        Assertions.assertEquals(damage, goblin.getDamage());
    }
}
