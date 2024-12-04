package main.java.project1;

/**
 * Author: Tharny Elilvannan
 * Last Updated: December 03, 2024
 * Purpose: Tic Tac Toe Board class.
 */

import java.util.Arrays;

public class Board {
 
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

    public boolean checkTie() {

        boolean tie = true;

        for (int i = 0; i < board.length; i++) {

            for (int j = 0; j < board.length; j++) {

                if (board[i][j] == "*") {

                    tie = false;

                }
                
            } // end of for loop

        } // end of for loop

        return tie;

    } // end of checkTie method

} // end of Board class


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

        } // end of if/else if statement

        return result;

    } // end of checkWin method

} // end of ImprovedBoard class