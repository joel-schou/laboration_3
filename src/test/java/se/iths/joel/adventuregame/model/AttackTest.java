package se.iths.joel.adventuregame.model;

import org.junit.jupiter.api.Test;
import se.sprinto.hakan.adventuregame.model.Giant;
import se.sprinto.hakan.adventuregame.model.Player;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AttackTest {

    @Test
    public void testAttack() {

        Giant enemy = new Giant("Jätte", 100, 0, 20);

        Player player = new Player.Builder()
                .setName("Joel")
                .setHealth(1000)
                .setScore(0)
                .setStrength(48)
                .build();

        player.attack(enemy);

        assertEquals(52, enemy.getHealth());
    }
}
