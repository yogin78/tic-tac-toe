package TicTacToe;

public interface Player {
    int makeMove(Board board);
    char getSymbol();
    String getName();
}

