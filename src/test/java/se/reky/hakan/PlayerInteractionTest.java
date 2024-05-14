package se.reky.hakan;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import se.reky.hakan.model.Player;

import java.util.Scanner;

public class PlayerInteractionTest {
    @Test
    public void testPlayerSetup() {
        // Här har jag skapat en instans av PlayerInteraction med hjälp av den privata metoden
        PlayerInteraction playerInteraction = createPlayerInteractionWithMockedInput("Alice");

        // för att Skapa en spelarinstans
        Player player = new Player();

        // Anropa playerSetup-metoden för att sätta spelarens namn
        playerInteraction.setupPlayer(player);

        // Verifiera att spelarens namn är satt korrekt
        Assertions.assertEquals("Alice", player.getName());
    }

    // Privat hjälpmetod för att skapa en instans av PlayerInteraction med mockad inmatning
    private PlayerInteraction createPlayerInteractionWithMockedInput(String playerName) {
        // Här har jag Skapat en instans av IOHandler med en Scanner instanserad med det tänkta namnet på spelaren
        IOHandler ioHandler = new IOHandler(new Scanner(playerName));

        // Skapa en instans av SimplePlayerInteraction med den nya IOHandler-instansen
        return new SimplePlayerInteraction(ioHandler);
    }
    @Test
    public void testUpdatePlayerHealth() {
        // Här har jag Skapat en instans av PlayerInteraction med hjälp av den privata metoden
        PlayerInteraction playerInteraction = createPlayerInteraction();

        // Här satte jag 10 på hälsan,Skapat en spelarinstans
        Player player = new Player();
        player.setHp(10);

        // Uppdaterat spelarens hälsa med 5
        playerInteraction.updatePlayerHealth(player, 5);

        // Verifiera att spelarens hälsa har uppdaterats korrekt
        Assertions.assertEquals(15, player.getHp());
    }

    // Privat hjälpmetod för att skapa en instans av PlayerInteraction
    private PlayerInteraction createPlayerInteraction() {
        // Skapa och returnera en instans av PlayerInteraction (t.ex. SimplePlayerInteraction)
        return new SimplePlayerInteraction(new IOHandler(new Scanner(System.in)));
    }
}
