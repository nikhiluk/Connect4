package uk.co.interviewprep3;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class Connect4GameTest {


    private  GameBoard gameBoard  = new GameBoard();;
    private  Connect4Game connect4Game= new Connect4Game(gameBoard);

    @Test
    public void playGameCheckingForVertical() {
        assertThat(connect4Game.move("X", 0), is(false));
        assertThat(connect4Game.move("O", 1), is(false));
        assertThat(connect4Game.move("X", 0), is(false));
        assertThat(connect4Game.move("O", 1), is(false));
        assertThat(connect4Game.move("X", 0), is(false));
        assertThat(connect4Game.move("O", 1), is(false));
        assertThat(connect4Game.move("X", 0), is(true));

        gameBoard = new GameBoard();
        connect4Game = new Connect4Game(gameBoard);
        assertThat(connect4Game.move("X", 0), is(false));
        assertThat(connect4Game.move("O", 1), is(false));
        assertThat(connect4Game.move("X", 2), is(false));
        assertThat(connect4Game.move("O", 1), is(false));
        assertThat(connect4Game.move("X", 3), is(false));
        assertThat(connect4Game.move("O", 1), is(false));
        assertThat(connect4Game.move("X", 0), is(false));
        assertThat(connect4Game.move("O", 1), is(true));
    }

    @Test
    public void playGameCheckingForHorizontal() {
        assertThat(connect4Game.move("X", 0), is(false));
        assertThat(connect4Game.move("O", 0), is(false));
        assertThat(connect4Game.move("X", 1), is(false));
        assertThat(connect4Game.move("O", 1), is(false));
        assertThat(connect4Game.move("X", 2), is(false));
        assertThat(connect4Game.move("O", 2), is(false));
        assertThat(connect4Game.move("X", 3), is(true));

        gameBoard = new GameBoard();
        connect4Game = new Connect4Game(gameBoard);
        assertThat(connect4Game.move("X", 6), is(false));
        assertThat(connect4Game.move("O", 1), is(false));
        assertThat(connect4Game.move("X", 5), is(false));
        assertThat(connect4Game.move("O", 1), is(false));
        assertThat(connect4Game.move("X", 4), is(false));
        assertThat(connect4Game.move("O", 1), is(false));
        assertThat(connect4Game.move("X", 3), is(true));
    }


    @Test
    public void playersCanOnlyPlaySequentially() {
        connect4Game.move("X", 0);
        try {
            connect4Game.move("X", 0);
            fail("should not be allowed");
        } catch (Exception e) {
           assertThat(e, is(instanceOf(OutOfSequenceException.class)));
        }
    }
}