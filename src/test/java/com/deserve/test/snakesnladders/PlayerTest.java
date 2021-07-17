package com.deserve.test.snakesnladders;

import static org.junit.Assert.assertTrue;

import com.deserve.test.snakesnladders.service.strategy.dice.impl.CrookedDice;
import com.deserve.test.snakesnladders.service.strategy.dice.impl.NormalDice;
import com.deserve.test.snakesnladders.util.PlayerUtil;
import org.junit.Test;

public class PlayerTest {


    @Test(expected = RuntimeException.class)
    public void playerCountLessThanZero_thanError() {
        PlayerUtil.validateNumOfPlayer(-1);
    }

    @Test(expected = RuntimeException.class)
    public void playerChanceLessThanZero_thanError() {
        PlayerUtil.validatePlayerChances(-1);
    }

    @Test
    public void NormalDiceRoll_valueBetween1To6() {
        NormalDice normalDice = new NormalDice();
        int dice = normalDice.roll();
        assertTrue(dice > 0 && dice < 7);
    }

    @Test
    public void CrookedDiceRoll_valueEven() {
        CrookedDice crookedDice = new CrookedDice();
        int dice = crookedDice.roll();
        assertTrue(dice % 2 == 0 && dice > 1 && dice < 7);
    }
}
