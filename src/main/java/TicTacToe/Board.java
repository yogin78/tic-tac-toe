package TicTacToe;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private final int size;
    private final List<String> board;
    private final int winCondition;

    public Board(int size) {
        this.size = size;
        this.board = new ArrayList<>();
        this.winCondition = (size == 10) ? 5 : size;
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < size * size; i++) {
            if (size == 3) {
                board.add(String.valueOf(i + 1));
            } else if (size == 10) {
                board.add(String.format("%02d", i));
            }
        }
    }

    public boolean makeMove(int position, char symbol) {
        if (position >= 0 && position < board.size() && board.get(position).matches("\\d+")) {
            board.set(position, String.valueOf(symbol));
            return true;
        }
        return false;
    }

    public void printBoard() {
        for (int i = 0; i < size * size; i++) {
            System.out.print(board.get(i) + " ");
            if ((i + 1) % size == 0) {
                System.out.println();
            }
        }
    }

    public boolean checkWin(char symbol) {
        return checkRows(symbol) || checkColumns(symbol) || checkDiagonals(symbol);
    }

    private boolean checkRows(char symbol) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j <= size - winCondition; j++) {
                boolean win = true;
                for (int k = 0; k < winCondition; k++) {
                    if (!board.get(i * size + j + k).equals(String.valueOf(symbol))) {
                        win = false;
                        break;
                    }
                }
                if (win) return true;
            }
        }
        return false;
    }

    private boolean checkColumns(char symbol) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j <= size - winCondition; j++) {
                boolean win = true;
                for (int k = 0; k < winCondition; k++) {
                    if (!board.get(j * size + i + k * size).equals(String.valueOf(symbol))) {
                        win = false;
                        break;
                    }
                }
                if (win) return true;
            }
        }
        return false;
    }

    private boolean checkDiagonals(char symbol) {
        // Check diagonals from top-left to bottom-right
        for (int i = 0; i <= size - winCondition; i++) {
            for (int j = 0; j <= size - winCondition; j++) {
                boolean win = true;
                for (int k = 0; k < winCondition; k++) {
                    if (!board.get((i + k) * size + j + k).equals(String.valueOf(symbol))) {
                        win = false;
                        break;
                    }
                }
                if (win) return true;
            }
        }

        // Check diagonals from top-right to bottom-left
        for (int i = 0; i <= size - winCondition; i++) {
            for (int j = winCondition - 1; j < size; j++) {
                boolean win = true;
                for (int k = 0; k < winCondition; k++) {
                    if (!board.get((i + k) * size + j - k).equals(String.valueOf(symbol))) {
                        win = false;
                        break;
                    }
                }
                if (win) return true;
            }
        }

        return false;
    }

    public boolean isFull() {
        for (String s : board) {
            if (s.matches("\\d+")) {
                return false;
            }
        }
        return true;
    }

    public int getSize() {
        return size;
    }
}
