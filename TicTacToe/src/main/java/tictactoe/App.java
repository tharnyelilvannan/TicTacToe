package tictactoe;

/**
 * Author: Tharny Elilvannan
 * Last Updated: December 02, 2024
 * Purpose: Tic Tac Toe game.
 */

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Game game = new Game();

    } // end of main method

} // end of App class


class Game {

    Game() {

        Board board = new Board();
        Player player1 = new Player("X", "Player 1");
        Player player2 = new Player("O", "Player 2");

        Scanner input = new Scanner(System.in);

        board.printBoard();

        int row = 0;
        int col = 0;

        int currentPlayer = 1;

        while (!win) {

            try {

                if (currentPlayer == 1) {

                    System.out.println(player1.getName() + ", where would you like to play?\n");

                    System.out.println("Row: ");
                    row = input.nextInt();

                    System.out.println("Column: ");
                    col = input.nextInt();

                    try {

                        board.checkBoard(row, col);

                        board.addMarker(row, col, player1.getMarker());

                    }
                    catch (Exception x) {
                        
                        System.out.println(x.getMessage());

                    } // end of try/catch statement
                }
                else if (currentPLayer == 2) {

                    System.out.println(player2.getName() + ", where would you like to play?\n");


                } 
                else {

                    throw new Exception("Invalid Player.");

                } // end of if/else statement

            }
            catch (Exception e) {

                System.out.println(e.getMessage());

            } // end of try/catch statement

        } // end of while loop

    } // end of Game method

} // end of Game class


class Player {

    private String marker = "";
    private String name = "";

    Player(String marker, String name) {

        this.marker = marker;
        this.name = name;

    } // end of Player method

    String getName() {

        return this.name;

    } // end of getName method

    String getMarker() {

        return this.marker;

    } // end of getMarker method

} // end of Player class


class Board {

    private String row1;
    private String row2;
    private String row3;
    private String divider = "-----------";
    private String[][] board = {{"0", "0", "0"}, {"0", "0", "0"}, {"0", "0", "0"}};

    Board() {

        this.row1 = "   |   |   ";
        this.row2 = "   |   |   ";
        this.row3 = "   |   |   ";

    } // end of Board method

    public void printBoard() {

        System.out.println(this.row1 + "\n" + divider + "\n" + this.row2+ "\n" + divider + "\n" + this.row3);

    } // end of printBoard method

    public void addMarker(int row, int col, String marker) {

        try {

            if ("X".equals(marker)) {

                board[row][col] = "X";

            }
            else if ("O".equals(marker)) {

                board[row][col] = "O";

            }
            else {

                throw new Exception("Invalid marker.");

            } // end of if/else statement

        } 
        catch (Exception e) {

            System.err.println(e.getMessage());

        } // end of try/catch statement

    } // end of addMarker method

    public void checkBoard(int row, int col) throws Exception {

        if (board[row][col] != "0") {

            throw new Exception("Position already filled.\n");

        }

    } // end of checkBoard method

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