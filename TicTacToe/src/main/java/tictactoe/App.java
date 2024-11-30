package tictactoe;

/**
 * Author: Tharny Elilvannan
 * Last Updated: November 28, 2024
 * Purpose: Tic Tac Toe game.
 */

public class App {

    public static void main(String[] args) {

        Game game = new Game();

    } // end of main method

} // end of App class


class Game {

    Game() {

        Board board = new Board();
        Player player1 = new Player("X");
        Player player2 = new Player("O");

        board.printBoard();

    } // end of Game method

} // end of Game class


class Player {

    private String marker = "";

    Player(String marker) {

        this.marker = marker;

    } // end of Player method

} // end of Player class


class Board {

    private String row1;
    private String row2;
    private String row3;
    private String divider = "-----------";
    private int[] board = {0, 0, 0, 0, 0, 0, 0, 0, 0};

    Board() {

        this.row1 = "   |   |   ";
        this.row2 = "   |   |   ";
        this.row3 = "   |   |   ";

    } // end of Board method

    public void printBoard() {

        System.out.println(this.row1 + "\n" + divider + "\n" + this.row2+ "\n" + divider + "\n" + this.row3);

    } // end of printBoard method

    public void addMarker(int position, String marker) {

        try {

            if ("X".equals(marker)) {

                board[position] = 1;

            }
            else if ("O".equals(marker)) {

                board[position] = 2;

            }
            else {

                throw new Exception("Invalid marker.");

            } // end of if/else statement

        } catch (Exception e) {

            System.err.println(e.getMessage());

        } // end of try/catch statement

    } // end of addMarker method

} // end of Board class


class HumanPlayer extends Player {

    HumanPlayer(String marker) {

        super(marker);

    } // end of HumanPlayer method

} // end of HumanPlayer class


class ComputerPlayer extends Player {

    ComputerPlayer(String marker) {

        super(marker);

    } // end of ComputerPlayer method

} // end of ComputerPlayer class