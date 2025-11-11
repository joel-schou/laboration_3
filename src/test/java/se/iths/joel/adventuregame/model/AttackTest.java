package se.iths.joel.adventuregame.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.sprinto.hakan.adventuregame.model.Giant;
import se.sprinto.hakan.adventuregame.model.Player;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AttackTest {
    private Giant giant;
    private Player player;

    @BeforeEach
    public void setup() {
        giant = new Giant(
                "Jätte",
                100,
                0,
                20);
        player = new Player.Builder()
                .setName("Joel")
                .setHealth(100)
                .setScore(0)
                .setStrength(48)
                .build();
    }

    @Test
    public void testAttack() {
        player.attack(giant);

        assertEquals(52, giant.getHealth());
    }
}
