package com.deserve.test.snakesnladders.service;

import com.deserve.test.snakesnladders.Board;
import com.deserve.test.snakesnladders.Jump;
import com.deserve.test.snakesnladders.Player;
import com.deserve.test.snakesnladders.properties.BoardProperties;
import com.deserve.test.snakesnladders.properties.LadderProperties;
import com.deserve.test.snakesnladders.properties.PlayerProperties;
import com.deserve.test.snakesnladders.properties.SnakeProperties;
import com.deserve.test.snakesnladders.util.BoardUtil;
import com.deserve.test.snakesnladders.util.JumpUtil;
import com.deserve.test.snakesnladders.util.PlayerUtil;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BoardService {

    private final BoardProperties boardProperties;
    private final LadderProperties ladderProperties;
    private final SnakeProperties snakeProperties;
    private final PlayerProperties playerProperties;

    private int boardSize;
    private int playerChance;
    private int numOfPlayer;

    private Map<Integer, Integer> ladders;
    private Map<Integer, Integer> snakes;

    @Autowired
    public BoardService(BoardProperties boardProperties, LadderProperties ladderProperties,
        SnakeProperties snakeProperties, PlayerProperties playerProperties) {

        this.boardProperties = boardProperties;
        this.ladderProperties = ladderProperties;
        this.snakeProperties = snakeProperties;
        this.playerProperties = playerProperties;

        initializeBoardData();

        BoardUtil.validateBoardSize(boardSize);
        PlayerUtil.validatePlayer(numOfPlayer, playerChance);
        JumpUtil.validateSnakeNLadderPositions(ladders, snakes, boardSize);

        Board board = initializeBoard();
        startGame(board);

    }

    private void initializeBoardData() {
        boardSize = boardProperties.getBoardSize();
        numOfPlayer = playerProperties.getNumOfPlayer();
        playerChance = playerProperties.getPlayerChances();
        ladders = ladderProperties.getLadderPositions();
        snakes = snakeProperties.getSnakePositions();
    }

    private Board initializeBoard() {
        Board board = new Board();
        board.setBoardSize(boardSize);

        Queue<Player> players = new LinkedList<Player>();
        for (int i = 0; i < numOfPlayer; i++) {
            players.add(new Player());
        }
        board.setPlayers(players);

        board.setLadder(new Jump(ladders));
        board.setSnakeJump(new Jump(snakes));

        return board;
    }

    private void startGame(Board board) {
        System.out.println("Welcome to snakes and Ladders !");
        displaySnakesNLadders();
        Queue<Player> players = board.getPlayers();

        boolean isAnyPlayerWon = false;

        while (playerChance > 0 && !isAnyPlayerWon) {
            int  playerNum = 1;
            for (Player player : players) {
                int dice = player.rollDice();
                int newPosition = player.getCurPos() + dice;

                if (newPosition <= boardSize) {
                    newPosition = checkForSnakeOrLadder(newPosition);
                    System.out.println("User moved to position : " + newPosition);
                    player.setCurPos(newPosition);
                } else {
                    System.out
                        .print("Player " + playerNum + " can't move ahead of board");
                }

                if (player.getCurPos() == boardSize) {
                    System.out.println("Player " +  playerNum + " won !");
                    isAnyPlayerWon = true;
                    break;
                }
                playerNum++;
            }
            playerChance--;
        }

        if (playerChance == 0) {
            System.out.println("Player couldn't make it within given chance");
        }
    }

    private int checkForSnakeOrLadder(int position) {
        if (ladders.get(position) != null) {
            System.out.println("Ladder took user from " + position + " to " + ladders.get(position));
            position = ladders.get(position);

            if (snakes.get(position) != null) {
                System.out.println("Snake took user from " + position + " to " + snakes.get(position));
                position = snakes.get(position);
            }
        } else  if (snakes.get(position) != null) {
            System.out.println("Snake took user from " + position + " to " + snakes.get(position));
            position = snakes.get(position);

            if (ladders.get(position) != null) {
                System.out.println("Ladder took user from " + position + " to " + ladders.get(position));
                position = ladders.get(position);
            }
        }

        return position;
    }

    public void displaySnakesNLadders() {
        System.out.println("Snake positions : ");
        snakes.forEach((key, value) -> {
            System.out.println( key + " --> " + value);
        });

        System.out.println("Ladder positions: ");
        ladders.forEach((key, value) -> {
           System.out.println(key + " --> " + value);
        });
    }
}
