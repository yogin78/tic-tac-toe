package TicTacToe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose board size: A for 3x3, B for 10x10");
        String choice = scanner.nextLine().toUpperCase();

        int size;
        if ("A".equals(choice)) {
            size = 3;
        } else if ("B".equals(choice)) {
            size = 10;
        } else {
            throw new IllegalArgumentException("Invalid choice. Please select A or B.");
        }

        Player human = new HumanPlayer('X');
        Player computer = new ComputerPlayer('O');

        GameLogic game = new GameLogic(human, computer, size);
        game.playGame();
    }
}
