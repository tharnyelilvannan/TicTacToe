package main.java.project1;

/**
 * Author: Tharny Elilvannan
 * Last Updated: December 03, 2024
 * Purpose: Tic Tac Toe Game class.
 */

import java.util.Scanner;

public class Game {

    public Game(int selection) throws Exception{

        if (selection == 1) {

            humanVsHuman();

        }
        else if (selection == 2) {

            humanVsComputer();
        }
        else if (selection == 3) {

            computerVsComputer();

        }
        else {

            throw new Exception("Invalid opponent selection.");

        } // end of if/else statement

    } // end of Game method

    // plays a human vs. human game
    private void humanVsHuman() {

        Scanner input = new Scanner(System.in);

        ImprovedBoard board = new ImprovedBoard();

        Player player1 = new HumanPlayer("X", "Player 1");
        Player player2 = new HumanPlayer("O", "Player 2");
        
        boolean playAgain = true;

        while (playAgain) {

            board.printBoard();

            int currentPlayer = 1;

            boolean win = false;
            boolean tie = false;

            while (!win && !tie) {

                try {

                    if (currentPlayer == 1) {

                        System.out.println("\n" + player1.getName() + ", where would you like to play?\n");

                        try {

                            int[] position = player1.position();

                            board.checkBoard(position[0], position[1]);

                            board.addMarker(position[0], position[1], player1.getMarker());

                            board.printBoard();

                            win = board.checkWin(player1.getMarker());
                            tie = board.checkTie();

                            if (win) {

                                System.out.println(player1.getName() + " wins!\n");

                            } 
                            else if (tie) {

                                System.out.println("It's a tie!\n");

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

                            int[] position = player1.position();

                            board.checkBoard(position[0], position[1]);

                            board.addMarker(position[0], position[1], player2.getMarker());

                            board.printBoard();

                            win = board.checkWin(player2.getMarker());
                            tie = board.checkTie();

                            if (win) {

                                System.out.println(player2.getName() + " wins!\n");

                            } 
                            else if (tie) {

                                System.out.println("It's a tie!\n");

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
    private void humanVsComputer() {

        Scanner input = new Scanner(System.in);

        ImprovedBoard board = new ImprovedBoard();

        Player player1 = new HumanPlayer("X", "Player 1");
        Player player2 = new ComputerPlayer("O", "Player 2");

        boolean playAgain = true;
                
        while (playAgain) {

            board.printBoard();

            int currentPlayer = 1;

            boolean win = false;
            boolean tie = false;

            while (!win  && !tie) {

                try {

                    if (currentPlayer == 1) {

                        System.out.println("\n" + player1.getName() + ", where would you like to play?\n");

                        try {

                            int[] position = player1.position();

                            board.checkBoard(position[0], position[1]);

                            board.addMarker(position[0], position[1], player1.getMarker());

                            board.printBoard();

                            win = board.checkWin(player1.getMarker());
                            tie = board.checkTie();

                            if (win) {

                                System.out.println("\nPlayer 1 wins!\n");

                            }
                            else if (tie) {

                                System.out.println("It's a tie!\n");

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

                            int[] position = player2.position();

                            board.checkBoard(position[0], position[1]);

                            board.addMarker(position[0], position[1], player2.getMarker());

                            board.printBoard();

                            win = board.checkWin(player2.getMarker());
                            tie = board.checkTie();

                            if (win) {

                                System.out.println("\nPlayer 2 wins!\n");

                            }
                            else if (tie) {

                                System.out.println("It's a tie!\n");

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
    private void computerVsComputer() {

        Scanner input = new Scanner(System.in);

        ImprovedBoard board = new ImprovedBoard();

        Player player1 = new ComputerPlayer("X", "Player 1");
        Player player2 = new ComputerPlayer("O", "Player 2");

        boolean playAgain = true;

        while (playAgain) {

            int currentPlayer = 1;

            boolean win = false;
            boolean tie = false;

            while (!win && !tie) {

                try {

                    if (currentPlayer == 1) {

                        System.out.println("\nComputer 1\n");

                        boolean valid = false;

                        while (!valid) {

                            try {

                                int[] position = player1.position();

                                board.checkBoard(position[0], position[1]);

                                board.addMarker(position[0], position[1], player1.getMarker());

                                board.printBoard();

                                win = board.checkWin(player1.getMarker());
                                tie = board.checkTie();

                                valid = true;

                                if (win) {

                                    System.out.println("\nComputer 1 wins!\n");

                                } 
                                else if (tie) {

                                    System.out.println("It's a tie!\n");

                                } // end of if/else statement

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

                                int[] position = player2.position();

                                board.checkBoard(position[0], position[1]);
    
                                board.addMarker(position[0], position[1], player2.getMarker());

                                board.printBoard();

                                win = board.checkWin(player2.getMarker());
                                tie = board.checkTie();

                                valid = true;

                                if (win) {

                                    System.out.println("\nComputer 2 wins!\n");

                                } 
                                else if (tie) {

                                    System.out.println("It's a tie!\n");

                                } // end of if/else statement

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