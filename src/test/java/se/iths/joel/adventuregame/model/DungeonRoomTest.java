package se.iths.joel.adventuregame.model;

import org.junit.jupiter.api.Test;
import se.iths.joel.adventuregame.view.FakeUI;
import se.sprinto.hakan.adventuregame.model.DungeonRoom;
import se.sprinto.hakan.adventuregame.model.Player;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DungeonRoomTest {

    @Test
    public void enterRoom() {
        DungeonRoom dungeonRoom = new DungeonRoom();

        FakeUI ui = new FakeUI();
        ui.setInput("a");

        Player player = new Player.Builder()
                .setName("Joel")
                .setHealth(100)
                .setScore(0)
                .setStrength(10)
                .build();

        dungeonRoom.enterRoom(player, ui);

        assertTrue(player.hasDefeatedEnemy());

    }
}
