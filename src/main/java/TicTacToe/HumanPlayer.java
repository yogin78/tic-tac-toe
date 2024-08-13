package TicTacToe;

import java.util.Scanner;

public class HumanPlayer implements Player {
    private final char symbol;
    private final String name;
    private final Scanner scanner;

    public HumanPlayer(char symbol) {
        this.symbol = symbol;
        this.name = "Human";
        this.scanner = new Scanner(System.in);
    }

    @Override
    public int makeMove(Board board) {
        int move;
        if (board.getSize() == 3) {
            System.out.println("Enter your move (1-9): ");
            move = scanner.nextInt() - 1;
        } else {
            System.out.println("Enter your move (00-99): ");
            String input = scanner.next();
            move = Integer.parseInt(input);
        }
        return move;
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

