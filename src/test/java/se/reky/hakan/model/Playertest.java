package se.reky.hakan.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Playertest {
    @Test
    public void testDefaultConstructor() {
        Player player = new Player();

        // Se till att Verifiering av standardvärdena är korrekta
        Assertions.assertNull(player.getName());
        Assertions.assertEquals(0, player.getHp());
        Assertions.assertEquals(0, player.getDamage());
        Assertions.assertNull(player.getWeapon());
        Assertions.assertEquals(0, player.getExperience());
        Assertions.assertFalse(player.isSilverRingObtained());
    }

    @Test
    public void testCustomConstructor() {
        // Här har jag Skapat en spelare med specifika värden
        String name = "Hero";
        int hp = 100;
        int damage = 20;
        Player player = new Player(name, hp, damage);
        player.setWeapon("Sword");
        player.setExperience(50);
        player.setSilverRingObtained(true);

        //  För att Verifiera att spelarens egenskaper är satta korrekt
        Assertions.assertEquals(name, player.getName());
        Assertions.assertEquals(hp, player.getHp());
        Assertions.assertEquals(damage, player.getDamage());
        Assertions.assertEquals("Sword", player.getWeapon());
        Assertions.assertEquals(50, player.getExperience());
        Assertions.assertTrue(player.isSilverRingObtained());
    }

    @Test
    public void testAddExperience() {
        Player player = new Player();
        player.setExperience(100);

        // Här har jag Lagt till 50 erfarenhetspoäng
        player.addExperience(50);

        // Här har jag Verifierat att spelarens totala erfarenhetspoäng är korrekt
        Assertions.assertEquals(150, player.getExperience());
    }
}
