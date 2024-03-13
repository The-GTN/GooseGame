package goosegame.cells;

import goosegame.Player;

/** 
 * Class for the board's cell of the gooseGame
 * @author Nollet Antoine Minaud Mathilde
 * @version 23/09/2020
 */
public abstract class Cell {

  /** the number of the cell */
  protected int number;
  /** the player of the cell */
  protected Player player;

  /** 
   * Construct a Cell with number i and player player
   * @param i the number of the cell
   * @param player the player of the cell
   */
  public Cell(int i, Player player) {
    this.number=i;
    this.player=player;
  }

  /** 
   * Construct an empty cell of number i
   * @param i the number of the cell
   * @see Cell(int,Player)
   */
  public Cell(int i) {
    this(i,null);
  }

  /** 
   * Retunrs a boolean to know if this cell is free or not
   * @return true if this cell is free, false otherwise
   */
  public boolean isFree() {
    return this.player == null;
  }

  /** 
   * Returns the player of this cell
   * @return the player of this cell
   */
  public Player getPlayer() {
    return this.player;
  }

  /** 
   * Set the player of this cell
   * @param player the player to set in this cell
   */
  public void setPlayer(Player player) {
    this.player = player;
  }

  /** 
   * Returns the number of this cell
   * @return the number of this cell
   */
  public int getNumber() {
    return this.number;
  }

  /** 
   * Clean this cell
   */
  public void clean() {
	  this.player = null;
  }

  /** 
   * Returns a boolean to check if this cell is a prison or not
   * @return true if this cell is a prison, false otherwise
   */
  public boolean isPrison() {
    return false;
  }

  /** 
   * Returns the String representation of this cell
   * @return the string representation of this cell
   */
  public String toString(){
    return "cell "+this.number;
  }

  /**
   * Returns the index of the cell after the effect on this cell based on the roll
   * @param move the resutlt of a dice roll
   * @return the index of the destination cell
   */
  public abstract int effect(int move);
  
}