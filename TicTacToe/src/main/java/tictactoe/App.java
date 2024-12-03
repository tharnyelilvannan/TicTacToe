package tictactoe;

/**
 * Author: Tharny Elilvannan
 * Last Updated: December 03, 2024
 * Purpose: Tic Tac Toe game.
 */

import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

public class App {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("\nWould you like to play against a computer or a player?\nPress 1 for human.\nPress 2 for computer.");
        System.out.println("If you would like to play computer vs. computer, press 3.\n");

        int humanOrComputer = input.nextInt();

        boolean valid = false;

        while (!valid) {

            try {

                if (humanOrComputer == 1) {

                    Game game = new Game();
                    valid = true;

                }
                else if (humanOrComputer == 2) {

                    Game game = new Game(1);
                    valid = true;
                }
                else if (humanOrComputer == 3) {

                    Game game = new Game(true);
                    valid = true;

                }
                else {

                    throw new Exception("Invalid opponent selection.");

                } // end of if/else statement

            }
            catch (Exception t) {

                System.out.println(t.getMessage());

            } // end of try/catch statement

        } // end of while loop

        input.close();

    } // end of main method

} // end of App class


class Game {

    // plays a human vs. human game
    Game() {

        Scanner input = new Scanner(System.in);

        ImprovedBoard board = new ImprovedBoard();

        Player player1 = new HumanPlayer("X", "Player 1");
        Player player2 = new HumanPlayer("O", "Player 2");
        
        boolean playAgain = true;

        while (playAgain) {

            board.printBoard();

            int row = 0;
            int col = 0;

            int currentPlayer = 1;

            boolean win = false;

            while (!win) {

                try {

                    if (currentPlayer == 1) {

                        System.out.println("\n" + player1.getName() + ", where would you like to play?\n");

                        try {

                            row = player1.row();

                            col = player1.col();

                            board.checkBoard(row, col);

                            board.addMarker(row, col, player1.getMarker());

                            board.printBoard();

                            win = board.checkWin(player1.getMarker());

                            if (win) {

                                System.out.println("\nPlayer 1 wins!\n");

                            } // end of if statement

                            currentPlayer = 2;

                        }
                        catch (Exception x) {
                            
                            System.out.println(x.getMessage());

                        } // end of try/catch statement
                    }
                    else if (currentPlayer == 2) {

                        System.out.println("\n" + player2.getName() + ", where would you like to play?\n");

                        try {

                            row = player2.row(); 

                            col = player2.col();

                            board.checkBoard(row, col);

                            board.addMarker(row, col, player2.getMarker());

                            board.printBoard();

                            win = board.checkWin(player2.getMarker());

                            if (win) {

                                System.out.println("\nPlayer 2 wins!\n");

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

            System.out.println("Do you want to play again? Type true for yes. Type false for no.\n");

            playAgain = input.nextBoolean();

            if (playAgain) {

                board.clearBoard();

            } // end of if statement

        } // end of while loop

        input.close();

    } // end of Game method

    // plays a human vs. computer game
    Game(int selection) {

        Scanner input = new Scanner(System.in);

        ImprovedBoard board = new ImprovedBoard();

        Player player1 = new HumanPlayer("X", "Player 1");
        Player player2 = new ComputerPlayer("O", "Player 2");

        boolean playAgain = true;
                
        while (playAgain) {

            board.printBoard();

            int row = 0;
            int col = 0;

            int currentPlayer = 1;

            boolean win = false;

            while (!win) {

                try {

                    if (currentPlayer == 1) {

                        System.out.println("\n" + player1.getName() + ", where would you like to play?\n");

                        try {

                            row = player1.row();

                            col = player1.col();

                            board.checkBoard(row, col);

                            board.addMarker(row, col, player1.getMarker());

                            board.printBoard();

                            win = board.checkWin(player1.getMarker());

                            if (win) {

                                System.out.println("\nPlayer 1 wins!\n");

                            } // end of if statement

                            currentPlayer = 2;

                        }
                        catch (Exception x) {
                            
                            System.out.println(x.getMessage());

                        } // end of try/catch statement
                    }
                    else if (currentPlayer == 2) {

                        //System.out.println("\nComputer's Turn\n");

                        try {

                            row = player2.row(); 

                            col = player2.col();

                            board.checkBoard(row, col);

                            board.addMarker(row, col, player2.getMarker());

                            board.printBoard();

                            win = board.checkWin(player2.getMarker());

                            if (win) {

                                System.out.println("\nPlayer 2 wins!\n");

                            } // end of if statement

                            currentPlayer = 1;

                        }
                        catch (Exception c) {
                            
                            //System.err.println(c.getMessage());

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

            System.out.println("Do you want to play again? Type true for yes. Type false for no.\n");

            playAgain = input.nextBoolean();

            if (playAgain) {

                board.clearBoard();

            } // end of if statement

        } // end of while loop

        input.close();

    } // end of Game method

    // plays a computer vs. computer game
    Game(boolean selection) {

        Scanner input = new Scanner(System.in);

        ImprovedBoard board = new ImprovedBoard();

        Player player1 = new ComputerPlayer("X", "Player 1");
        Player player2 = new ComputerPlayer("O", "Player 2");

        boolean playAgain = true;

        while (playAgain) {
                    
            int row = 0;
            int col = 0;

            int currentPlayer = 1;

            boolean win = false;

            while (!win) {

                try {

                    if (currentPlayer == 1) {

                        System.out.println("\nComputer 1\n");

                        boolean valid = false;

                        while (!valid) {

                            try {

                                row = player1.row();

                                col = player1.col();

                                board.checkBoard(row, col);

                                board.addMarker(row, col, player1.getMarker());

                                board.printBoard();

                                win = board.checkWin(player1.getMarker());

                                valid = true;

                                if (win) {

                                    System.out.println("\nComputer 1 wins!\n");

                                } // end of if statement

                                currentPlayer = 2;

                            }
                            catch (Exception x) {
                                
                                //System.err.println(x.getMessage());

                            } // end of try/catch statement
                        
                        } // end of while loop
                    }
                    else if (currentPlayer == 2) {

                        System.out.println("\nComputer 2\n");

                        boolean valid = false;
                        
                        while (!valid) {

                            try {

                                row = player2.row(); 

                                col = player2.col();

                                board.checkBoard(row, col);

                                board.addMarker(row, col, player2.getMarker());

                                board.printBoard();

                                win = board.checkWin(player2.getMarker());

                                valid = true;

                                if (win) {

                                    System.out.println("\nComputer 2 wins!\n");

                                } // end of if statement

                                currentPlayer = 1;

                            }
                            catch (Exception c) {
                                
                                //System.err.println(c.getMessage());

                            } // end of try/catch statement
                        
                        } // end of while loop

                    } 
                    else {

                        throw new Exception("Invalid Player.");

                    } // end of if/else statement

                }
                catch (Exception p) {

                    System.out.println(p.getMessage());

                } // end of try/catch statement

            } // end of while loop

            System.out.println("Do you want to play again? Type true for yes. Type false for no.\n");

            playAgain = input.nextBoolean();

            if (playAgain) {

                board.clearBoard();

            } // end of if statement

        } // end of while loop

        input.close();

    } // end of Game method

} // end of Game class


abstract class Player {

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

    abstract int row() throws Exception;

    abstract int col() throws Exception;

} // end of Player class


class Board {

    String[][] board = {{"*", "*", "*"}, {"*", "*", "*"}, {"*", "*", "*"}};
    
    Board() {

    } // end of Board method

    public void printBoard() {

        for (int i = 0; i < board.length; i++) {
            
            System.out.println(Arrays.toString(board[i]));

        } // end of for loop

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

    public void clearBoard() {

        for (int i = 0; i < board.length; i++) {

            for (int j = 0; j < board.length; j++) {

                board[i][j] = "*";
                
            } // end of for loop

        } // end of for loop

    } // end of clearBoard method

} // end of Board class
    
    
class HumanPlayer extends Player {

    Scanner input = new Scanner(System.in);
    
    HumanPlayer(String marker, String name) {

        super(marker, name);

    } // end of HumanPlayer method

    int row() throws Exception {

        System.out.println("Row: ");
        int row = input.nextInt();

        // assume user will enter rows as 1, 2, or 3
        row = row - 1; 

        if (row >= 3) {

            throw new Exception("Row value must be 1, 2, or 3.");

        } // end of if statement

        return row;

    } // end of row method

    int col() throws Exception {

        System.out.println("Column: ");
        int col = input.nextInt();

        // assume user will enter columns as 1, 2, or 3
        col = col - 1;

        if (col >= 3) {

            throw new Exception("Column value must be 1, 2, or 3.");

        } // end of if statement

        return col;

    } // end of col method

} // end of HumanPlayer class


class ComputerPlayer extends Player {

    Random random = new Random();

    ComputerPlayer(String marker, String name) {

        super(marker, name);

    } // end of ComputerPlayer method

    int row() throws Exception {
        
        int row = random.nextInt(3);

        return row;

    } // end of row method

    int col() throws Exception {

        int col = random.nextInt(3);

        return col;

    } // end of col method

} // end of ComputerPlayer class


class ImprovedBoard extends Board {

    ImprovedBoard() {

        super();

    } // end of ImprovedBoard method

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
        else if (board[0][2] == marker && board[1][1] == marker && board[2][0] == marker) {

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