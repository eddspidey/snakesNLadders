package com.deserve.test.snakesnladders;

import com.deserve.test.snakesnladders.util.JumpUtil;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class LadderTest {

    @Test(expected = RuntimeException.class)
    public void ladderTakesDown_thanError() {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(3, 15);
        map.put(21, 2);

        JumpUtil.validateLadderJump(map, 100);
    }

    @Test(expected = RuntimeException.class)
    public void ladderTakesMoreThanBoardSize_thanError() {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(3, 15);
        map.put(21, 101);

        JumpUtil.validateLadderJump(map, 100);
    }

    @Test(expected = RuntimeException.class)
    public void ladderFromZero_thanError() {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(3, 15);
        map.put(0, 20);

        JumpUtil.validateLadderJump(map, 100);
    }

    @Test(expected = RuntimeException.class)
    public void ladderKeyOrValueNegative_thanError() {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(3, 15);
        map.put(-2, 20);

        JumpUtil.validateLadderJump(map, 100);
    }
}
