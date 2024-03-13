package goosegame;

import goosegame.cells.*;
import goosegame.cells.Cell;
import java.util.*;

/** 
 * Class for the Game of GooseGame
 * @author Nollet Antoine Minaud Mathilde
 * @version 23/09/2020
 */
public class Game {

  private static final Random ALEA = new Random();
  /** the board of this game */
  protected Board board;
  /** the list of the players of this game */
  protected List<Player> players;
  

  /** 
   * Construct a game with the board board
   * @param board the board of this game
   */
  public Game(Board board) {
    this.board = board;
    this.players = new ArrayList<Player>();
  }

  /** 
   * Add a player to this game
   * @param player the player to add
   */
  public void addPlayer(Player player) {
    this.board.initPlayer(player);
    this.players.add(player);
  }

  /** 
   * returns this game's list of players
   * @return this game's list of players
   */
  public List<Player> getPlayers() {
    return this.players;
  }

  /** 
   * Returns the board of this game
   * @return the board of this game
   */
  public Board getBoard() {
    return this.board;
  }

  /** 
   * Reset the game and send all the players in the start cell
   */
  public void resetGame() {
    this.board.clean();
    List<Player> previousliste = this.players;
    this.players = new ArrayList<Player>();
    for(int i = 0; i!=previousliste.size();i++) this.addPlayer(previousliste.get(i));
  }

  /** 
   * Returns a boolean to check if all players are stuck in prison
   * @return true if all players are stuck in prison, false otherwise
   */
  protected boolean isStuck() {
    int nbPrisonners = 0;
    Player player;
    Cell cell;
    for(int i = 0; i!=this.players.size();i++) {
      player = this.players.get(i);
      cell = player.getCell();
	  if(cell instanceof PrisonCell && !(cell instanceof WaitCell)) {nbPrisonners++;}
    }
    return nbPrisonners == this.players.size();
  }

  /** 
   * Returns a boolean to check if this game is won or not
   * @return true if this game is won, false otherwise
   */
  protected boolean isWin() {
    return !this.board.getCell(this.board.getNbOfCells()).isFree();
  }

  /**
   *  Check if the parameters given are valid and start the game
   */
  public void play() {
    System.out.println("");
    if(this.players.size() == 0) System.out.println("You can't play to this game without players !");
    if(this.isStuck()) System.out.println("You can't play to this game, all the players are trapped !");
    if(this.isWin()) System.out.println("You can't play to this game, this game is already finished !");
    else {
    	System.out.println("Game start !");
    	this.thePlay();
    }
  }

  /** Returns the next Player p of the this's list of players
  * @param p the current Player
  * @return the player after p in the list, if p is the last player or the player isn't in the list, then the next player is the first one  
  */
  public Player getNextPlayer(Player p){
    int index = players.indexOf(p);
    if( index+ 1 >= players.size() | index < 0 ){
      
      return players.get(0);
    }
    else{
      return players.get(index+1);
    }
  }

  /**
   * The play of this game
   */
  protected void thePlay() {

    boolean finished = false;
    Player currentPlayer = this.getFirstPlayer();

    while(!finished) {
      int rollDices = this.twoDiceThrow();
      this.movePlayer(currentPlayer,rollDices);
      if(this.isStuck() || this.isWin()) finished = true;
      this.getNextPlayer(currentPlayer);
     
    }
    if(this.isStuck())
      System.out.println("Every players are in prison... Nobody can win.");
    else 
      System.out.println(this.board.getCell(this.board.getNbOfCells()).getPlayer()+" has won.");
  }

  /**
   * Move the player p on the next cell if they can
   * @param p The player
   * @param rollDices The result of the roll
   */
  public void movePlayer(Player p,int rollDices){
    if(canMove(p)){
     Cell nextCell = this.nextCell(p,rollDices);
     this.board.movePlayers(p.getCell(),nextCell);
    }
  }

  /**
   * Returns if the Player p can move (true) or not (false)
   * @param p The player
   * @return true if the player can move, false overwise
   */
  public boolean canMove(Player p){
    Cell cell = p.getCell();
    if (cell.isPrison()){
      String message = p+" is in cell "+cell+", "+p+" cannot play.";
      System.out.println(message);
    }
    return !cell.isPrison();
  }

  /**
   * Returns the cell on which the player land, according to the dice roll and the effect of the cell
   * @param p The Player
   * @param rollDices The result of the dices roll
   * @return the cell's index on which the player land
   */
  public Cell nextCell(Player p, int rollDices){
	  Cell cell = p.getCell();
	  int currentIndex = cell.getNumber();
    Cell nextCell = this.board.getNextCell(currentIndex+rollDices);
    Cell finalCell = this.applyEffect(nextCell,rollDices);
    printMessage(p,rollDices,nextCell,finalCell);
    return finalCell;
  }

  /**
   * Print the message describing the movement of players
   * @param p the player
   * @param rollDices the results off the roll
   * @param nextcell the cell after applying the roll
   * @param finalCell the cell after applying the roll and the effect
   */
  private void printMessage(Player p,int rollDices,Cell nextCell,Cell finalCell){
    Cell cell = p.getCell();
    int currentIndex = cell.getNumber();
    String message = p+" is in cell "+currentIndex+", "+p+" "+"throws "+rollDices+" and reaches "+nextCell;
    if( finalCell != nextCell)
      message += " and jumps to "+finalCell;
    if(!this.nextCellIsFree(cell, finalCell))
  	  message = message+" cell is busy, "+finalCell.getPlayer()+" is sent to "+cell;
    System.out.println(message);
  }
  
  /**
   * Returns a Cell by applying the effect of the Cell cell based on the dice roll
   * @param cell The current Cell
   * @param roll The dice roll
   * @return The destination Cell
   */
  public Cell applyEffect(Cell cell, int roll) {
	  int destination = cell.effect(roll);
	  Cell finalCell = this.board.getNextCell(destination);
	  return finalCell;
  }
  
  /**
   * Returns the first player of the game
   * @return the first player
   */
  public Player getFirstPlayer() {
	  return this.board.start.getPlayer();
  }
  
  public boolean nextCellIsFree(Cell prev, Cell next){
	boolean empty = next.isFree() ;
	boolean same = prev.getPlayer() == next.getPlayer();
	return empty || same;
  }
  

  /**
   * Returns the result of a 1D6 
   * @return a random int between 1 and 6
   */
  private int oneDieThrow() {	
     return ALEA.nextInt(6)+ 1; 
  }


  /**
   * Returns the results of 2D6
   * @return a random int between 2 and 12
   */
  public int twoDiceThrow() {
      int result = oneDieThrow() + oneDieThrow();
      return result;
  }

}
