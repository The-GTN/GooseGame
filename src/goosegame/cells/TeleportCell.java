package goosegame.cells;

import goosegame.*;

/** 
 * Class for TeleportCell of this GooseGame
 * @author Nollet Antoine Minaud Mathilde
 * @version 23/09/2020
 */
public class TeleportCell extends Cell {

  /** the destination of teleportation of this TeleportCell */
  protected int destination;

  /** 
   * Construct a TeleportCell of number i and with the player player and the destination destination
   * @param i the number of the cell
   * @param player the player of the cell
   * @param destination the index of the destination cell of this cell
   * @see Cell#Cell(int, Player)
   */
  public TeleportCell(int i, Player player, int destination) {
    super(i,player);
    this.destination = destination;
  }

  /**
   * Construct an empty TeleportCell of number i and destination destination
   * @param i the number of the cell
   * @param destination the index of the destination cell of this cell
   * @see TeleportCell(int,Player,int)
   */
  public TeleportCell(int i, int destination) {
    super(i);
    this.destination = destination;
  }

  /** 
   * Returns the index of the cell after the effect on this cell based on the roll
   * @param move the resutlt of a dice roll
   * @return the index of the destination cell
   * @see Cell#effect(int move)
   */
  public int effect(int move) {
    return this.destination;
  }

  /** 
   * Returns the String representation of this cell
   * @return the string representation of this cell
   * @see Cell#toString()
   */
  public String toString() {
    return super.toString()+" (teleport to "+this.destination+")";
  }

}
