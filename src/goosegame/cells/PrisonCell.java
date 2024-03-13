package goosegame.cells;

import goosegame.*;

/** 
 * Class for Prison cell of the GooseGame
 * @author Nollet Antoine Minaud Mathilde
 * @version 23/09/2020
 */
public class PrisonCell extends Cell {

  /** construct a PrisonCell with player player and number i
   * @param i the number of the cell
   * @param player the player of the cell
   * @see Cell#Cell(int, Player)
  */
  public PrisonCell(int i, Player player) {
    super(i,player);
  }
  
  /** 
   * Construct an empty PrisonCell of number i
   * @param i the number of the cell
   * @see Cell#Cell(int)
   */
   public PrisonCell(int i) {
     super(i);
   }
	  
  /** 
   * Returns the index of the cell after the effect on this cell based on the roll
   * @param move the resutlt of a dice roll
   * @return the index of the destination cell
   * @see Cell#effect(int move)
   */
  public int effect(int move) {
    return this.number;
  }

  /**
   * Returns a boolean to check if this cell is a prison or not
   * @return true if this cell is a prison, false otherwise
   */
  public boolean isPrison() {
    return true;
  }

  /** 
   * Returns a boolean to check if this cell is a prison forever or not
   * @return true if this cell is a prison forever, false otherwise
   */
  public boolean isDefinitive() {
    return true;
  }

  /** 
   * Returns the String representation of this cell
   * @return the string representation of this cell
   * @see Cell#toString()
   */
  public String toString() {
    return super.toString()+" (trap)";
  }

}
