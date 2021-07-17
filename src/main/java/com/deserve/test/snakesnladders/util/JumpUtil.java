package com.deserve.test.snakesnladders.util;

import com.deserve.test.snakesnladders.constants.GeneralExceptionConstants;
import java.util.Map;

public class JumpUtil {

    public static void validateSnakeNLadderIntersection(Map<Integer, Integer> ladders, Map<Integer, Integer> snakes) {
        ladders.forEach((key, value) -> {
            if (snakes.get(key) != null) {
                throw new RuntimeException(GeneralExceptionConstants.SNAKE_LADDER_CANT_INTERSECT);
            }
        });
    }

    public static void validateLadderJump(Map<Integer, Integer> ladderMap, int boardSize) {
        ladderMap.forEach((key, value) -> {
            if (value < key) {
                throw new RuntimeException(GeneralExceptionConstants.LADDER_SCHEMA_INCORRECT_EXCEPTION);
            } else if (key == 0) {
                throw new RuntimeException(GeneralExceptionConstants.LADDER_CANT_BE_AT_0);
            } else if (value > boardSize) {
                throw new RuntimeException(GeneralExceptionConstants.LADDER_CANT_TAKE_BEYOND_SIZE);
            } else if (key <= 0 || value <= 0) {
                throw new RuntimeException(GeneralExceptionConstants.VALUES_NON_NEGATIVE);
            }
        });
    }

    public static void validateSnakeJump(Map<Integer, Integer> snakeMap, int boardSize) {
        snakeMap.forEach((key, value) -> {
            if (value > key) {
                throw new RuntimeException(GeneralExceptionConstants.SNAKE_SCHEMA_INCORRECT_EXCEPTION);
            } else if (key == boardSize) {
                throw new RuntimeException(GeneralExceptionConstants.SNAKE_CANT_BE_AT_END);
            } else if (value < 0) {
                throw new RuntimeException(GeneralExceptionConstants.SNAKE_CANT_TAKE_BELOW_0);
            } else if (key < 0 || value < 0) {
                throw new RuntimeException(GeneralExceptionConstants.VALUES_NON_NEGATIVE);
            }
        });
    }

    public static void validateSnakeNLadderPositions(Map<Integer, Integer> ladders,
        Map<Integer, Integer> snakes, int endPosition) {

        JumpUtil.validateSnakeNLadderIntersection(ladders, snakes);
        JumpUtil.validateLadderJump(ladders, endPosition);
        JumpUtil.validateSnakeJump(snakes, endPosition);
    }


}
