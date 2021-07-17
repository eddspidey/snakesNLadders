package com.deserve.test.snakesnladders.service.strategy.dice.impl;

import com.deserve.test.snakesnladders.service.strategy.dice.DiceStrategy;
import java.util.concurrent.ThreadLocalRandom;

public class NormalDice implements DiceStrategy {

    @Override
    public int roll() {
        return ThreadLocalRandom.current().nextInt(1, 7);
    }
}
