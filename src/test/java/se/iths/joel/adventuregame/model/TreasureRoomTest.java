package se.iths.joel.adventuregame.model;

import org.junit.jupiter.api.Test;
import se.iths.joel.adventuregame.view.FakeUI;
import se.sprinto.hakan.adventuregame.model.Player;
import se.sprinto.hakan.adventuregame.model.TreasureRoom;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TreasureRoomTest {

    @Test
    public void testTreasureRoom() {
        TreasureRoom treasureRoom = new TreasureRoom();

        FakeUI ui = new FakeUI();
        ui.setInput("nej");

        Player player = new Player.Builder()
                .setName("Joel")
                .setHealth(100)
                .setScore(0)
                .setStrength(10)
                .setFoundKey(true)
                .build();

        treasureRoom.enterRoom(player, ui);

        assertTrue(player.hasOpenedChest());
        assertEquals(100, player.getScore());
    }
}
