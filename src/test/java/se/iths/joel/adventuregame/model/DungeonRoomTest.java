package se.iths.joel.adventuregame.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.iths.joel.adventuregame.view.FakeUI;
import se.sprinto.hakan.adventuregame.model.DungeonRoom;
import se.sprinto.hakan.adventuregame.model.Player;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DungeonRoomTest {
    private FakeUI UI;
    private DungeonRoom dungeonRoom;
    private Player player;

    @BeforeEach
    public void setUp() {
        UI = new FakeUI();
        dungeonRoom = new DungeonRoom();
        player = new Player.Builder()
                .setName("Joel")
                .setHealth(100)
                .setScore(0)
                .setStrength(50)
                .setHasShield(true)
                .build();
    }

    @Test
    public void testDungeonRoom() {
        UI.setInputs("a");

        dungeonRoom.enterRoom(player, UI);

        assertTrue(player.hasDefeatedEnemy());
    }

    @Test
    public void testDungeonRoomR() {
        UI.setInputs("r");

        dungeonRoom.enterRoom(player, UI);

        assertFalse(player.hasDefeatedEnemy());
    }
}
