package com.deserve.test.snakesnladders.service.strategy.dice.impl;

import com.deserve.test.snakesnladders.service.strategy.dice.DiceStrategy;
import java.util.concurrent.ThreadLocalRandom;

public class CrookedDice implements DiceStrategy {

    @Override
    public int roll() {
        while (true) {
            int random = ThreadLocalRandom.current().nextInt(1, 7);
            if (random % 2 == 0) {
                return random;
            }
        }
    }
}
