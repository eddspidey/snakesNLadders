package com.deserve.test.snakesnladders;

import java.util.Queue;
import lombok.Data;

@Data
public class Board {

    private Queue<Player> players;
    private Jump ladder;
    private Jump snakeJump;

    private int boardSize;

}
