package se.sprinto.hakan.adventuregame.model;

public class Player extends AbstractCharacter {
    private boolean foundKey;
    private boolean defeatedEnemy;
    private boolean openedChest;
    private boolean hasShield;

    private Player(Builder builder) {
        super(builder.name, builder.health, builder.score, builder.strength);
        this.foundKey = builder.foundKey;
        this.defeatedEnemy = builder.defeatedEnemy;
        this.openedChest = builder.openedChest;
        this.hasShield = builder.hasShield;
    }

    public static class Builder {
        private String name;
        private int health;
        private int score;
        private int strength;
        private boolean foundKey;
        private boolean defeatedEnemy;
        private boolean openedChest;
        private boolean hasShield;


        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setHealth(int health) {
            this.health = health;
            return this;
        }

        public Builder setScore(int score) {
            this.score = score;
            return this;
        }

        public Builder setStrength(int strength) {
            this.strength = strength;
            return this;
        }

        public Builder setFoundKey(boolean foundKey) {
            this.foundKey = foundKey;
            return this;
        }

        public Builder setHasShield(boolean hasShield) {
            this.hasShield = hasShield;
            return this;
        }

        public Builder setOpenedChest(boolean openedChest) {
            this.openedChest = openedChest;
            return this;
        }

        public Player build() {
            return new Player(this);
        }
    }


    public boolean hasFoundKey() {
        return foundKey;
    }

    public void setFoundKey(boolean foundKey) {
        this.foundKey = foundKey;
    }

    public boolean hasDefeatedEnemy() {
        return defeatedEnemy;
    }


    public void setDefeatedEnemy(boolean defeatedEnemy) {
        this.defeatedEnemy = defeatedEnemy;
    }

    public boolean hasOpenedChest() {
        return openedChest;
    }

    public void setOpenedChest(boolean openedChest) {
        this.openedChest = openedChest;
    }

    public boolean hasWon() {
        return foundKey && defeatedEnemy && openedChest;
    }

    public void setHasShield(boolean hasShield) {
        this.hasShield = hasShield;
    }

    public boolean hasShield() {
        return hasShield;
    }

    @Override
    public void attack(AbstractCharacter target) {
        target.setHealth(target.getHealth() - this.getStrength());

        if (!target.isAlive()) {
            addScore(50);
        }
    }
}
