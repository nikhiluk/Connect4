package uk.co.interviewprep3;

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
}
