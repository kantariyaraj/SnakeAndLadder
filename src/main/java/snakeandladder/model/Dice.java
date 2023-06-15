package snakeandladder.model;

import java.util.Random;

public class Dice {
    int sides;
    Random random;

    public Dice(int sides) {
        this.sides = sides;
        random = new Random();
    }

    int rollDice(){
        return random.nextInt(sides) + 1;
    }
}
