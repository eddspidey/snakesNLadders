package com.deserve.test.snakesnladders.util;

import com.deserve.test.snakesnladders.constants.GeneralExceptionConstants;

public class BoardUtil {

    public static void validateBoardSize(int boardSize) {
        if (boardSize <= 0) {
            throw new RuntimeException(GeneralExceptionConstants.BOARD_SIZE_NON_NEGATIVE);
        }
    }

}
