package tictactoe;

/**
 * Author: Tharny Elilvannan
 * Last Updated: November 25, 2024
 * Purpose: Tic Tac Toe game.
 */


public class App {

    public static void main(String[] args) {

        Game g = new Game();

    } // end of main method

} // end of App class


class Game {

    Game() {

        Board board = new Board();

    } // end of Game method

} // end of Game class


class Player {

    String marker = "";

    Player(String marker) {

        this.marker = marker;

    } // end of Player method

} // end of Player class


class Board {

    String board = "";

    Board() {

        this.board = "  |  |  \n--------\n  |  |  \n--------\n  |  |  ";

    } // end of Board method

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