package goosegame.cells;

import goosegame.*;

/**
 * Class for WaitCell of the GooseGame
 * @author Nollet Antoine Minaud Mathilde
 * @version 23/09/2020
 */
public class WaitCell extends PrisonCell {

  protected int WAIT;
  protected int wait;

  /** 
   * Construct a WaitCell of number i and with the player player
   * @param i the number of the cell
   * @param player the player of the cell
   * @see Cell#Cell(int, Player)
   */
  public WaitCell(int i, Player player, int wait) {
    super(i,player);
    this.WAIT = wait;
    this.wait = wait;
  }

  /** 
   * Construct an empty WaitCell of number i
   * @param i the number of the cell
   * @see Cell#Cell(int)
   */
  public WaitCell(int i, int wait) {
    this(i,null,wait);
  }

  /** 
   * Returns boolean to check if this cell is a prison or not
   * @return true if this cell is a prison, false otherwise
   */
  public boolean isPrison() {
    if(this.wait==0) {
      this.wait = this.WAIT;
      return false;
    }
    else {
      this.wait--;
      return true;
    }
  }

  /** 
   * Returns boolean to check if this cell is a prison forever or not
   * @return true if this cell is a prison forever, false otherwise
   */
  public boolean isDefinitive() {
    return false;
  }

  /** 
   * Returns the String representation of this cell
   * @return the string representation of this cell
   * @see Cell#toString()
   */
  public String toString() {
    return super.toString()+" (waiting for "+this.WAIT+" turns )";
  }

}
