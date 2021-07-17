package com.deserve.test.snakesnladders.util;

import com.deserve.test.snakesnladders.constants.GeneralExceptionConstants;

public class PlayerUtil {

    public static void validatePlayer(int numOfPlayer, int playerChance) {
        validateNumOfPlayer(numOfPlayer);
        validatePlayerChances(playerChance);
    }

    public static void validateNumOfPlayer(int numOfPlayer) {
        if (numOfPlayer <= 0) {
            throw new RuntimeException(GeneralExceptionConstants.TOTAL_PLAYER_NON_NEGATIVE);
        }
    }

    public static void validatePlayerChances(int playerChance) {
        if (playerChance <= 0) {
            throw new RuntimeException(GeneralExceptionConstants.PLAYER_CHANCE_NON_NEGATIVE);
        }
    }


}
