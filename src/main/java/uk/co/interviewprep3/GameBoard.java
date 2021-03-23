package uk.co.interviewprep3;

public class GameBoard {

    private static final int numberOfColumns = 7;
    private static final int numberOfRows = 6;
    private String[][] cells = new String[numberOfRows][numberOfColumns];
    public static final int CONSECUTIVE_TARGET = 4;

    public GameBoard() {
        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfColumns; j++) {
                cells[i][j] = ".";
            }
        }
    }

    public String[][] printState() {
        for (String[] cell : cells) {
            for (String s : cell) {
                System.out.print(s);
            }
            System.out.println();
        }
        return cells;
    }

    public void addCounter(String player, int column) {
        for (int i = numberOfRows - 1; i >= 0; i--) {
            if (cells[i][column].equals(".")) {
                cells[i][column] = player;
                break;
            }
        }
    }

    public boolean checkConsecutiveVertical(String player) {
        for (int i = 0; i < numberOfColumns; i++) {
            if (checkVertical(player, i)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkVertical(String player, int column) {
        int numberOfConsecutives = 0;
        for (int i = numberOfRows - 1; i >= 0; i--) {
            if (cells[i][column].equals(player)) {
                numberOfConsecutives++;
                if (numberOfConsecutives == CONSECUTIVE_TARGET) {
                    return true;
                }
            } else {
                numberOfConsecutives = 0;
            }
        }
        return false;
    }

    public boolean checkConsecutiveHorizontal(String player) {
        for(int i = numberOfRows-1; i>=0; i--) {
            if (checkHorizontal(player, i)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkHorizontal(String player, int row) {
        int numberOfConsecutives = 0;
        for(int i =0; i < numberOfColumns; i++) {
            if (cells[row][i].equals(player)) {
                numberOfConsecutives++;
                if (numberOfConsecutives == CONSECUTIVE_TARGET) {
                    return true;
                }
            } else {
                numberOfConsecutives = 0;
            }
        }
        return false;
    }
}
