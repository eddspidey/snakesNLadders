package com.deserve.test.snakesnladders.service.helper;

import com.deserve.test.snakesnladders.service.strategy.dice.DiceStrategy;
import com.deserve.test.snakesnladders.service.strategy.dice.impl.CrookedDice;
import com.deserve.test.snakesnladders.service.strategy.dice.impl.NormalDice;
import org.springframework.stereotype.Service;

@Service
public class DiceStrategyHelper {

    public static DiceStrategy getStrategy(boolean hasStarted) {
        return hasStarted ? new NormalDice() : new CrookedDice();
    }
}
