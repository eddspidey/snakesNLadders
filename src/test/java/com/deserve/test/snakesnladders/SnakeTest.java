package com.deserve.test.snakesnladders;

import com.deserve.test.snakesnladders.util.JumpUtil;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class SnakeTest {

    @Test(expected = RuntimeException.class)
    public void snakeTakesUp_thanError() {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(3, 15);
        map.put(21, 2);

        JumpUtil.validateSnakeJump(map, 100);
    }

    @Test(expected = RuntimeException.class)
    public void ladderTakesLessThanZero_thanError() {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(3, -1);
        map.put(21, 12);

        JumpUtil.validateSnakeJump(map, 100);
    }

    @Test(expected = RuntimeException.class)
    public void snakeAtBoardSize_thanError() {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(31, 15);
        map.put(100, 20);

        JumpUtil.validateSnakeJump(map, 100);
    }

    @Test(expected = RuntimeException.class)
    public void snakeKeyOrValueNegative_thanError() {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(31, 15);
        map.put(-12, -20);

        JumpUtil.validateSnakeJump(map, 100);
    }
}
