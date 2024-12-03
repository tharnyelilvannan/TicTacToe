package tictactoe;

/**
 * Author: Tharny Elilvannan
 * Last Updated: December 02, 2024
 * Purpose: Tic Tac Toe game.
 */

import java.util.Scanner;
import java.util.Arrays;

public class App {

    public static void main(String[] args) {

        Game game = new Game();

    } // end of main method

} // end of App class


class Game {

    Game() {

        ImprovedBoard board = new ImprovedBoard();
        Player player1 = new Player("X", "Player 1");
        Player player2 = new Player("O", "Player 2");

        Scanner input = new Scanner(System.in);

        board.printBoard();

        int row = 0;
        int col = 0;

        int currentPlayer = 1;

        boolean win = false;

        while (!win) {

            try {

                if (currentPlayer == 1) {

                    System.out.println("\n" + player1.getName() + ", where would you like to play?\n");

                    System.out.println("Row: ");
                    row = input.nextInt();

                    // assume user will enter rows as 1, 2, or 3
                    row = row - 1; 

                    System.out.println("Column: ");
                    col = input.nextInt();

                    // assume user will enter columns as 1, 2, or 3
                    col = col - 1;

                    if (row >= 3 || col >= 3) {

                        throw new Exception("Row and column value must be 1, 2, or 3.");

                    } // end of if statement

                    try {

                        board.checkBoard(row, col);

                        board.addMarker(row, col, player1.getMarker());

                        board.printBoard();

                        win = board.checkWin(player1.getMarker());

                        if (win) {

                            System.out.println("Player 1 wins!\n");

                        } // end of if statement

                        currentPlayer = 2;

                    }
                    catch (Exception x) {
                        
                        System.out.println(x.getMessage());

                    } // end of try/catch statement
                }
                else if (currentPlayer == 2) {

                    System.out.println("\n" + player2.getName() + ", where would you like to play?\n");

                    System.out.println("Row: ");
                    row = input.nextInt();

                    // assume user will enter rows as 1, 2, or 3
                    row = row - 1; 

                    System.out.println("Column: ");
                    col = input.nextInt();

                    // assume user will enter columns as 1, 2, or 3
                    col = col - 1;

                    if (row >= 3 || col >= 3) {

                        throw new Exception("Row and column value must be 1, 2, or 3.");

                    } // end of if statement

                    try {

                        board.checkBoard(row, col);

                        board.addMarker(row, col, player2.getMarker());

                        board.printBoard();

                        win = board.checkWin(player2.getMarker());

                        if (win) {

                            System.out.println("Player 2 wins!\n");

                        } // end of if statement

                        currentPlayer = 1;

                    }
                    catch (Exception c) {
                        
                        System.out.println(c.getMessage());

                    } // end of try/catch statement

                } 
                else {

                    throw new Exception("Invalid Player.");

                } // end of if/else statement

            }
            catch (Exception p) {

                System.out.println(p.getMessage());

            } // end of try/catch statement

        } // end of while loop

        input.close();

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

    protected String[][] board = {{"*", "*", "*"}, {"*", "*", "*"}, {"*", "*", "*"}};
    
        public void printBoard() {
    
            System.out.println(Arrays.toString(board[0]));
            System.out.println(Arrays.toString(board[1]));
            System.out.println(Arrays.toString(board[2]));
    
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
    
            if (board[row][col] != "*") {
    
                throw new Exception("Position already filled.\n");
    
            } // end of if statement
    
        } // end of checkBoard method
    
    } // end of Board class
    
    
class HumanPlayer extends Player {
    
    HumanPlayer(String marker, String name) {

        super(marker, name);

    } // end of HumanPlayer method

} // end of HumanPlayer class


class ComputerPlayer extends Player {

    ComputerPlayer(String marker, String name) {

        super(marker, name);

    } // end of ComputerPlayer method

} // end of ComputerPlayer class


class ImprovedBoard extends Board {

    public boolean checkWin(String marker) {

        boolean result = false;

        if (board[0][0] == marker && board[0][1] == marker && board[0][2] == marker) {

            result = true;

        }
        else if (board[1][0] == marker && board[1][1] == marker && board[1][2] == marker) {

            result = true;

        }
        else if (board[2][0] == marker && board[2][1] == marker && board[2][2] == marker) {

            result = true;

        }
        else if (board[0][0] == marker && board[1][1] == marker && board[2][2] == marker) {

            result = true;

        }
        else if (board[0][2] == marker && board[1][1] == marker && board[2][1] == marker) {

            result = true;

        }
        else if (board[0][0] == marker && board[1][0] == marker && board[2][0] == marker) {

            result = true;

        }
        else if (board[0][1] == marker && board[1][1] == marker && board[2][1] == marker) {

            result = true;

        }
        else if (board[0][2] == marker && board[1][2] == marker && board[2][2] == marker) {

            result = true;

        }

    return result;

    } // end of checkWin method

} // end of ImprovedBoard class