package se.reky.hakan.service;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;
import se.reky.hakan.model.Player;
import se.reky.hakan.web.PlayerController;


import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;




public class PlayerControllerTest {
    @Mock
    private PlayerService playerService;

    @Mock
    private Model model;

    @InjectMocks
    private PlayerController playerController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testListPlayers() {
        // Arrange
        List<Player> players = Collections.singletonList(new Player());

        when(playerService.findAllPlayersSortedByExperience()).thenReturn(players);

        // Act
        String viewName = playerController.listPlayers(model);

        // Assert
        assertEquals("players", viewName);
        verify(model, times(1)).addAttribute(eq("players"), eq(players));
        verify(playerService, times(1)).findAllPlayersSortedByExperience();
    }

    @Test
    void testPlayerById() {
        // Arrange
        Player player = new Player();
        Long playerId = 1L;
        when(playerService.findPlayerById(playerId)).thenReturn(player);

        // Act
        String viewName = playerController.playerById(playerId, model);

        // Assert
        assertEquals("player", viewName);
        verify(model, times(1)).addAttribute(eq("player"), eq(player));
        verify(playerService, times(1)).findPlayerById(playerId);
    }
}
