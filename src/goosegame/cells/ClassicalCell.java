package goosegame.cells;


import goosegame.*;
/**
 * Class for the board's Classicalcell of the gooseGame
 * @author Nollet Antoine Minaud Mathilde
 * @version 23/09/2020
 */

public class ClassicalCell extends Cell {

  /** 
   * Construct a ClassicalCell with number i and player player
   * @param i the number of the cell
   * @param player the player of the cell
   * @see Cell#Cell(int, Player)
   */
  public ClassicalCell(int i, Player player) {
    super(i, player);
  }

  /** 
   * Construct an empty ClassicalCell of number i
   * @param i the number of the cell
   * @see Cell#Cell(int)
   */
  public ClassicalCell(int i) {
    this(i,null);
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

}
