package TicTacToe;

public class GameLogic {
    private final Player player1;
    private final Player player2;
    private final Board board;

    public GameLogic(Player player1, Player player2, int size) {
        this.player1 = player1;
        this.player2 = player2;
        this.board = new Board(size);
    }

    public void playGame() {
        Player currentPlayer = player1;
        while (true) {
            board.printBoard();
            System.out.println(currentPlayer.getName() + "'s turn (" + currentPlayer.getSymbol() + "):");
            int move = currentPlayer.makeMove(board);
            if (board.makeMove(move, currentPlayer.getSymbol())) {
                if (board.checkWin(currentPlayer.getSymbol())) {
                    board.printBoard();
                    System.out.println(currentPlayer.getName() + " wins!");
                    break;
                }
                if (board.isFull()) {
                    board.printBoard();
                    System.out.println("It's a draw!");
                    break;
                }
                currentPlayer = (currentPlayer == player1) ? player2 : player1;
            } else {
                System.out.println("Invalid move, try again.");
            }
        }
    }
}

