package goosegame.cells;

import goosegame.*;
import java.util.*;

/** 
 * Class for the board's start cell of the gooseGame
 * @author Nollet Antoine Minaud Mathilde
 * @version 23/09/2020
 */
public class StartCell extends Cell {

  /** the players in this StartCell */
  protected List<Player> players;

  /**
   * Construct a StartCell with the players
   * @param players the list of the players
   * @see Cell#Cell(player)
   */
  public StartCell(List<Player> players) {
    super(0,null);
    this.players = players;
  }

  /** 
   * Construct an empty StartCell
   * @see StartCell(List<Player>)
   */
  public StartCell() {
    this(new ArrayList<Player>());
  }

  /** 
   * Add the player to this startcell
   * @param player the player to add
   */
  public void setPlayer(Player player) {
    this.players.add(player);
  }


  /** 
   * Returns the players of this startcell
   * @return the list of players of this cell
   */
  public List<Player> getPlayers() {
    return this.players;
  }
  
  /**
   * Returns the first player of this startcell
   * @return the first player of this start cell
   */
   public Player getPlayer() {
     return this.players.get(0);
   }

  /** 
   * Clean this cell, remove the first player of this start cell 
   */
  public void clean() {
	  this.players.remove(0);
  }

  /** 
   * The String representation of this cell
   * @return the string representation of this cell
   * @see Cell#toString()
   */
  public String toString() {
    return "start cell";
  }

  /** 
   * Returns the index of the cell after the effect on this cell based on the roll
   * @param move the resutlt of a dice roll
   * @return the index of the destination cell
   * @see Cell#effect(int move)
   */
  public int effect(int move){
    return 0;
  }
  
}
