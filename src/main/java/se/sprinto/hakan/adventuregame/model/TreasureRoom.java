package se.sprinto.hakan.adventuregame.model;

import se.sprinto.hakan.adventuregame.view.UI;

public class TreasureRoom implements Room {
    private boolean goblinDefeated = false;

    @Override
    public void enterRoom(Player player, UI ui) {

        ui.showMessage("Du befinner dig i skattkammaren och du möts av en goblin");

        if (goblinDefeated) {
            ui.showMessage("Du ser resterna av goblinen");
        } else {
            Goblin goblin = new Goblin("Goblin", 20, 0, 12);

            while (player.isAlive() && goblin.isAlive()) {
                String choice = ui.getInput("Vill du (a)ttackera eller (r)etirera?");
                if (choice.equalsIgnoreCase("a")) {
                    player.attack(goblin);
                    ui.showMessage("Du attackerar goblin! Goblins HP: " + goblin.getHealth());
                    if (goblin.isAlive()) {
                        goblin.attack(player);
                        ui.showMessage("Goblin attackerar dig! Ditt HP: " + player.getHealth());
                    } else {
                        ui.showMessage("Du besegrade goblin!");
                        goblinDefeated = true;
                        ui.showMessage("Goblin tappade sin sköld!");
                        String choiceOne = ui.getInput("Vill du plocka upp Skölden? Ja/nej");
                        if (choiceOne.equalsIgnoreCase("Ja")) {
                            ui.showMessage("Du plockade upp skölden!");
                            player.setHasShield(true);
                        } else if (choiceOne.equalsIgnoreCase("Nej")) {
                            ui.showMessage("Du lämnade skölden på marken!");
                        }
                    }
                } else if (choice.equalsIgnoreCase("r")) {
                    ui.showMessage("Du springer därifrån!");
                    return;
                } else {
                    ui.showMessage("fel val!");
                }
            }

            ui.showMessage("Du hittar en skattkista. Den verkar låst...");

            String choiceTwo = ui.getInput("Vill du försöka öppna kistan? (ja/nej)");
            if (choiceTwo.equalsIgnoreCase("ja")) {
                if (player.hasFoundKey()) {
                    ui.showMessage("Du öppnar kistan med din nyckel!");
                    player.setOpenedChest(true);
                    player.addScore(100);
                } else {
                    ui.showMessage("Kistan är låst, du saknar nyckeln...");
                }
            } else {
                ui.showMessage("Du lämnar kistan orörd.");
            }

        }
    }
}
