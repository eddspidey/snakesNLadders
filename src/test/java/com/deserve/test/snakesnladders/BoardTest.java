package com.deserve.test.snakesnladders;

import com.deserve.test.snakesnladders.util.BoardUtil;
import com.deserve.test.snakesnladders.util.JumpUtil;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class BoardTest {

    @Test(expected = RuntimeException.class)
    public void boardSizeZeroThanError() {
        BoardUtil.validateBoardSize(-1);
    }

    @Test(expected = RuntimeException.class)
    public void snakeAndLadderInterSect_thanError() {
        Map<Integer, Integer> ladderMap = new HashMap<Integer, Integer>();
        ladderMap.put(3, 15);
        ladderMap.put(21, 44);

        Map<Integer, Integer> snakeMap = new HashMap<Integer, Integer>();
        snakeMap.put(31, 15);
        snakeMap.put(21, 7);

        JumpUtil.validateSnakeNLadderIntersection(ladderMap, snakeMap);
    }


}
