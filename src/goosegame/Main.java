package goosegame;

import goosegame.boards.*;
import io.Input;

/** 
 * Main class for the GooseGame project
 * @author Nollet Antoine Minaud Mathilde
 * @version 23/09/2020
 */
public class Main {

  /** Main method of this Main class
  * @param args there no needs to enter arguments
  */
  public static void main(String[] args) {
    Board board = new ClassicalBoard();
    Game game = new Game(board);
    createPlayers(game);
    game.play();
  }

  /** Create and input Players in the Game game
  * @param game the game we want to put new players
  */
  private static void createPlayers(Game game) {
    System.out.println("How much players ? (not 0 or less or more than 10)");
    int nbPlayers;
    String name;
    try {
      nbPlayers = Input.readInt();
      if (nbPlayers <= 0 ||nbPlayers > 10) {
        System.out.println("You don't give a correct number of players, so there will be 2 players.");
        nbPlayers = 2;
      }
    }
    catch(java.io.IOException e) {
      System.out.println("You don't give a correct number of players, so there will be 2 players.");
      nbPlayers = 2;
    }
    for(int i=1;i!=nbPlayers+1;i++) {
      System.out.println("Player J"+i+", what's your name ?");
      name = Input.readString();
      game.addPlayer(new Player(name));
    }
  }

}
