package se.iths.joel.adventuregame.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.iths.joel.adventuregame.view.FakeUI;
import se.sprinto.hakan.adventuregame.model.Player;
import se.sprinto.hakan.adventuregame.model.TreasureRoom;

import static org.junit.jupiter.api.Assertions.*;

public class TreasureRoomTest {
    private FakeUI UI;
    private TreasureRoom treasureRoom;
    private Player player;

    @BeforeEach
    public void setUp() {
        UI = new FakeUI();
        treasureRoom = new TreasureRoom();
        player = new Player.Builder()
                .setName("Joel")
                .setHealth(100)
                .setScore(0)
                .setStrength(50)
                .setFoundKey(true)
                .build();
    }

    @Test
    public void testTreasureRoom() {
        UI.setInput("a");
        UI.setInput("ja");
        UI.setInput("ja");

        treasureRoom.enterRoom(player, UI);

        assertTrue(player.hasOpenedChest());
        assertEquals(150, player.getScore());
    }
}
