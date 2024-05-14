package se.reky.hakan.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import se.reky.hakan.model.Actor;

public class ActorTest {

    // Jag har implementera ConcreteActor-klassen här för att kunna fortsatta med ActorTest klassen.
    public static class ConcreteActor extends Actor {

        public ConcreteActor(String name, int hp, int damage) {
            super(name, hp, damage);
        }
    }

    @Test
    public void testAttack() {
        // Här har jag Skapat en attackerande Actor med namn, hp och damage
        Actor attacker = new ConcreteActor("Attacker", 10, 5);

        // Här har jag Skapat en försvarande Actor med namn, hp och damage
        Actor defender = new ConcreteActor("Defender", 10, 2);

        // Spara den försvarandes ursprungliga hälsa
        int originalDefenderHp = defender.getHp();

        attacker.attack(defender);

        //  Här blir Förväntad hälsominus för försvararen efter attacken
        int expectedDefenderHpAfterAttack = originalDefenderHp - attacker.getDamage();

        // Verifiera att den attackerades hälsa har minskat korrekt
        Assertions.assertEquals(expectedDefenderHpAfterAttack, defender.getHp());
    }
}
