package TicTacToe;

import java.util.Random;

public class ComputerPlayer implements Player {
    private final char symbol;
    private final String name;
    private final Random random;

    public ComputerPlayer(char symbol) {
        this.symbol = symbol;
        this.name = "Computer";
        this.random = new Random();
    }

    @Override
    public int makeMove(Board board) {
        return random.nextInt(board.getSize() * board.getSize());
    }

    @Override
    public char getSymbol() {
        return symbol;
    }

    @Override
    public String getName() {
        return name;
    }
}
