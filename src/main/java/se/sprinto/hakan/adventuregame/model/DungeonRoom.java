package se.sprinto.hakan.adventuregame.model;

import se.sprinto.hakan.adventuregame.view.UI;

public class DungeonRoom implements Room {

    @Override
    public void enterRoom(Player player, UI ui) {
        ui.showMessage("Du går ner i en kall fängelsehåla. En vätte står i vägen!");
        Giant giant = new Giant("Vätte", 30, 0, 50);

        while (player.isAlive() && giant.isAlive()) {
            String choice = ui.getInput("Vill du (a)ttackera eller (r)etirera?");
            if (choice.equalsIgnoreCase("a")) {
                player.attack(giant);
                ui.showMessage("Du attackerar vätten!");
                if (giant.isAlive()) {
                    ui.showMessage("Vättens HP = " + giant.getHealth());
                    int damage = giant.getStrength();
                    if (player.hasShield()) {
                        damage /= 2;
                        ui.showMessage("Jätten skadar mindre på grund av din sköld!");
                    }
                    player.setHealth(player.getHealth() - damage);
                    ui.showMessage("Vätten attackerar dig! SKADA= " + damage);
                    ui.showMessage("Ditt HP " + player.getHealth());

                } else {
                    ui.showMessage("Du besegrade vätten!");
                    player.setDefeatedEnemy(true);
                }
            } else if (choice.equalsIgnoreCase("r")) {
                ui.showMessage("Du springer därifrån!");
                break;
            }
        }
    }
}

