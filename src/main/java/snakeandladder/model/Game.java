package snakeandladder.model;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Game {
    Board board;
    Queue<Player> players;
    Dice dice;
    GameState state;

    public Game(Board board, Dice dice) {
        this.board = board;
        this.dice = dice;
        players = new LinkedList<>();
        state = GameState.NOT_STARTED;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void startGame() throws Exception {
        if (players.size() < 1)
            throw new Exception("No players configured for the game");

        Scanner s = new Scanner(System.in);

        //Start the game
        System.out.println("=====================Game is in progress=======================");
        state = GameState.IN_PROGRESS;

        while (players.size() > 1) {
            System.out.println("Press enter to continue....");
            s.nextLine();

            //Fetch the current player
            Player currPlayer = players.poll();
            System.out.println("Current player is " + currPlayer.getName() + " standing at position " + currPlayer.getCurrPos());

            //Roll the dice
            int val = dice.rollDice();
            System.out.println("Dice values is " + val);

            int currPos = currPlayer.getCurrPos();

            //If Snake or Ladder is present at the target position we need to move the
            //player according to that
            if (currPos + val <= board.size * board.size) {
                currPlayer.setCurrPos(currPos + val);
                if (board.specialEntityPresent(currPlayer.getCurrPos())) {
                    currPlayer.setCurrPos(board.getEntityAtPos(currPlayer.getCurrPos()).getEnd());
                }
            }

            System.out.println("New position of player is " + currPlayer.getCurrPos());

            //Check if player has won
            if (currPlayer.getCurrPos() == board.size * board.size) {
                System.out.println("Player " + currPlayer.getName() + " has won!!!");
            } else {
                players.offer(currPlayer);
            }
        }

        System.out.println("=============Game is completed==============");
        state = GameState.COMPLETED;
    }
}
