package com.deserve.test.snakesnladders;

import com.deserve.test.snakesnladders.service.helper.DiceStrategyHelper;
import com.deserve.test.snakesnladders.service.strategy.dice.DiceStrategy;
import lombok.Data;

@Data
public class Player {

    private String playerName;

    private DiceStrategy diceStrategy;

    private int curPos;

    private boolean hasStarted;

    public int rollDice() {
        diceStrategy = DiceStrategyHelper.getStrategy(hasStarted);
        int dice = diceStrategy.roll();
        if (!hasStarted && dice == 6) {
            System.out.println("Player got 6, game has started");
            hasStarted = true;
            return rollDice();
        } else {
            System.out.println("Player got " + dice);
        }
        if (!hasStarted) {
            System.out.println("Player stuck at 0 as game hasn't started");
        }

        return hasStarted ? dice : 0;
    }
}
