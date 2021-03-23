package uk.co.interviewprep3;

import java.util.Scanner;

import static java.lang.String.format;

public class Connect4Game {


    private final GameBoard gameBoard;
    private String lastPlayer = null;

    public Connect4Game(GameBoard gameBoard) {
        this.gameBoard = gameBoard;
    }

    public boolean move(String player, int columnToEnter) {
        if (player.equalsIgnoreCase(lastPlayer)) {
            throw new OutOfSequenceException();
        }
        this.lastPlayer = player;

        gameBoard.addCounter(player, columnToEnter);
        gameBoard.printState();
        return gameBoard.checkConsecutiveVertical(player) || gameBoard.checkConsecutiveHorizontal(player);
    }

    public static void main(String[] args) {
        GameBoard gameBoard = new GameBoard();
        Connect4Game connect4Game = new Connect4Game(gameBoard);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            final String[] input = scanner.next().split(",");
            final String playerToken = input[0];
            final int column = Integer.parseInt(input[1]);
            final boolean winner = connect4Game.move(playerToken, column);
            if (winner) {
                System.out.println("Player " + playerToken + " has won");
                break;
            }
        }

    }
}
