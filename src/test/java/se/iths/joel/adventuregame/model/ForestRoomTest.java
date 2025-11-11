package se.iths.joel.adventuregame.model;

import org.junit.jupiter.api.Test;
import se.iths.joel.adventuregame.view.FakeUI;
import se.sprinto.hakan.adventuregame.model.ForestRoom;
import se.sprinto.hakan.adventuregame.model.Player;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ForestRoomTest {
    @Test
    public void testEnterRoom() {
        ForestRoom forestRoom = new ForestRoom();

        FakeUI ui = new FakeUI();
        ui.setInputs("ja");

        Player player = new Player.Builder()
                .setName("Joel")
                .setHealth(100)
                .setScore(0)
                .setStrength(10)
                .build();

        forestRoom.enterRoom(player, ui);

        assertTrue(player.hasFoundKey());
    }
}
