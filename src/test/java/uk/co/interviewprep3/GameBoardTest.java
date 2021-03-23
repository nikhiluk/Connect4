package uk.co.interviewprep3;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class GameBoardTest {

    private GameBoard gameBoard = new GameBoard();

    @Test
    public void initialiseGameBoard() {
        String[][] expectedBoardState = createBlankBoard();
        String[][] boardState = gameBoard.printState();
        assertThat(boardState, is(expectedBoardState));
    }

    @Test
    public void correctlyOutputStateAfterMoves() {
        String[][] expectedBoardState = createBlankBoard();

        gameBoard.addCounter("X", 0);
        expectedBoardState[5][0] = "X";
        assertThat(gameBoard.printState(), is(expectedBoardState));

        gameBoard.addCounter("O", 0);
        expectedBoardState[4][0] = "O";
        assertThat(gameBoard.printState(), is(expectedBoardState));

        gameBoard.addCounter("X", 0);
        expectedBoardState[3][0] = "X";
        assertThat(gameBoard.printState(), is(expectedBoardState));

        gameBoard.addCounter("X", 2);
        expectedBoardState[5][2] = "X";
        assertThat(gameBoard.printState(), is(expectedBoardState));

        gameBoard.addCounter("O", 1);
        expectedBoardState[5][1] = "O";
        assertThat(gameBoard.printState(), is(expectedBoardState));

        gameBoard.addCounter("X", 2);
        expectedBoardState[4][2] = "X";
        assertThat(gameBoard.printState(), is(expectedBoardState));
    }

    @Test
    public void checkConsecutiveVerticalForFirstColumn() {
        gameBoard.addCounter("X", 0);
        assertThat(gameBoard.checkConsecutiveVertical("X"), is(false));

        gameBoard.addCounter("X", 0);
        assertThat(gameBoard.checkConsecutiveVertical("X"), is(false));

        gameBoard.addCounter("X", 0);
        assertThat(gameBoard.checkConsecutiveVertical("X"), is(false));

        gameBoard.addCounter("X", 0);
        assertThat(gameBoard.checkConsecutiveVertical("X"), is(true));

        gameBoard = new GameBoard();
        gameBoard.addCounter("X", 0);
        assertThat(gameBoard.checkConsecutiveVertical("X"), is(false));

        gameBoard.addCounter("O", 0);
        assertThat(gameBoard.checkConsecutiveVertical("X"), is(false));

        gameBoard.addCounter("X", 0);
        assertThat(gameBoard.checkConsecutiveVertical("X"), is(false));

        gameBoard.addCounter("X", 0);
        assertThat(gameBoard.checkConsecutiveVertical("X"), is(false));

        gameBoard.addCounter("X", 0);
        assertThat(gameBoard.checkConsecutiveVertical("X"), is(false));

        gameBoard.addCounter("X", 0);
        assertThat(gameBoard.checkConsecutiveVertical("X"), is(true));

    }

    @Test
    public void checkConsecutiveVerticaAcrossColumns() {
        gameBoard.addCounter("X", 0);
        gameBoard.addCounter("X", 0);
        gameBoard.addCounter("X", 0);
        gameBoard.addCounter("O", 0);
        assertThat(gameBoard.checkConsecutiveVertical("X"), is(false));

        gameBoard.addCounter("X", 1);
        gameBoard.addCounter("X", 1);
        gameBoard.addCounter("X", 1);
        gameBoard.addCounter("O", 1);
        assertThat(gameBoard.checkConsecutiveVertical("X"), is(false));

        gameBoard.addCounter("X", 2);
        gameBoard.addCounter("O", 2);
        gameBoard.addCounter("X", 2);
        gameBoard.addCounter("X", 2);
        gameBoard.addCounter("X", 2);
        gameBoard.addCounter("X", 2);
        assertThat(gameBoard.checkConsecutiveVertical("X"), is(true));

        gameBoard = new GameBoard();
        gameBoard.addCounter("X", 6);
        gameBoard.addCounter("X", 6);
        gameBoard.addCounter("X", 6);
        gameBoard.addCounter("X", 6);
        gameBoard.addCounter("O", 6);
        gameBoard.addCounter("O", 6);
        assertThat(gameBoard.checkConsecutiveVertical("X"), is(true));
    }


    @Test
    public void checkConsecutiveHorizontalForFirstRow() {
        gameBoard.addCounter("X", 0);
        assertThat(gameBoard.checkConsecutiveHorizontal("X"), is(false));

        gameBoard.addCounter("X", 1);
        assertThat(gameBoard.checkConsecutiveHorizontal("X"), is(false));

        gameBoard.addCounter("X", 2);
        assertThat(gameBoard.checkConsecutiveHorizontal("X"), is(false));

        gameBoard.addCounter("X", 3);
        assertThat(gameBoard.checkConsecutiveHorizontal("X"), is(true));

    }

    @Test
    public void checkForHorizontalAcrossRows() {
        gameBoard.addCounter("X", 0);
        assertThat(gameBoard.checkConsecutiveHorizontal("X"), is(false));

        gameBoard.addCounter("O", 1);
        assertThat(gameBoard.checkConsecutiveHorizontal("X"), is(false));

        gameBoard.addCounter("O", 2);
        assertThat(gameBoard.checkConsecutiveHorizontal("X"), is(false));

        gameBoard.addCounter("O", 3);
        assertThat(gameBoard.checkConsecutiveHorizontal("X"), is(false));

        gameBoard.addCounter("X", 0);
        assertThat(gameBoard.checkConsecutiveHorizontal("X"), is(false));

        gameBoard.addCounter("X", 1);
        assertThat(gameBoard.checkConsecutiveHorizontal("X"), is(false));

        gameBoard.addCounter("X", 2);
        assertThat(gameBoard.checkConsecutiveHorizontal("X"), is(false));

        gameBoard.addCounter("X", 3);
        assertThat(gameBoard.checkConsecutiveHorizontal("X"), is(true));
    }


    private String[][] createBlankBoard() {
        String[][] expectedBoardState = new String[6][7];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                expectedBoardState[i][j] = ".";
            }
        }
        return expectedBoardState;
    }

}