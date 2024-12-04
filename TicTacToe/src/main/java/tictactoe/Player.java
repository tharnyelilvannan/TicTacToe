package main.java.project1;

/**
 * Author: Tharny Elilvannan
 * Last Updated: December 03, 2024
 * Purpose: Tic Tac Toe Player class.
 */

import java.util.Scanner;
import java.util.Random;

public abstract class Player {

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

    abstract int[] position() throws Exception;

} // end of Player class


class HumanPlayer extends Player {
 
    Scanner input = new Scanner(System.in);
    
    HumanPlayer(String marker, String name) {

        super(marker, name);

    } // end of HumanPlayer method

    int[] position() throws Exception {

        System.out.println("Row: ");
        int row = input.nextInt();

        // assume user will enter rows as 1, 2, or 3
        row = row - 1; 

        if (row >= 3) {

            throw new Exception("Row value must be 1, 2, or 3.");

        } // end of if statement

        System.out.println("Column: ");
        int col = input.nextInt();

        // assume user will enter rows as 1, 2, or 3
        row = col - 1; 

        if (col >= 3) {

            throw new Exception("Column value must be 1, 2, or 3.");

        } // end of if statement

        int[] position = {row, col};

        return position;

    } // end of row method

} // end of HumanPlayer class


class ComputerPlayer extends Player {
 
    Random random = new Random();

    ComputerPlayer(String marker, String name) {

        super(marker, name);

    } // end of ComputerPlayer method

    int[] position() throws Exception {

        int row = random.nextInt(3);
        int col = random.nextInt(3);

        int[] position = {row, col};

        return position;

    } // end of position method

} // end of ComputerPlayer class