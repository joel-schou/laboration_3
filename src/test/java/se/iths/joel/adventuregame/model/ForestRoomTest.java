package se.iths.joel.adventuregame.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.iths.joel.adventuregame.view.FakeUI;
import se.sprinto.hakan.adventuregame.model.ForestRoom;
import se.sprinto.hakan.adventuregame.model.Player;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ForestRoomTest {
    private FakeUI UI;
    private ForestRoom forestRoom;
    private Player player;

    @BeforeEach
    public void setUp() {
        UI = new FakeUI();
        forestRoom = new ForestRoom();
        player = new Player.Builder()
                .setName("Joel")
                .setHealth(100)
                .setScore(0)
                .setStrength(10)
                .build();
    }

    @Test
    public void testForestRoom() {
        UI.setInputs("ja");

        forestRoom.enterRoom(player, UI);

        assertTrue(player.hasFoundKey());
    }
}
