package goosegame.boards;

import goosegame.*;
import goosegame.cells.*;
import goosegame.cells.Cell;

/** 
 * Class for a ClassicalBoard for the GooseGame
 * @author Nollet Antoine Minaud Mathilde
 * @version 23/09/2020
 */
public class ClassicalBoard extends Board {

  /** 
   * Construct a ClassicalBoard
   */
  public ClassicalBoard() {
    super(63);
  }

  /** 
   * Initialize the cells of this board
   * @see Board#initBoard()
   */
  protected void initBoard() {
    this.theCells = new Cell[64];
    for(int i = 0; i!=64;i++) {
      if(this.isGooseCell(i)) this.initCell(i, new GooseCell(i) );
      else if(this.isPrisonCell(i)) this.initCell(i, new PrisonCell(i) );
      else if(this.isWaitCell(i)) this.initCell(i, new WaitCell(i,2) );
      else if(this.isTeleportCell(i)) {
        if(i==6) this.initCell(i, new TeleportCell(i,12) );
        else if(i==42) this.initCell(i, new TeleportCell(i,30) );
        else if(i==58) this.initCell(i, new TeleportCell(i,50) );
      }
      else this.initCell(i,new ClassicalCell(i));
    }
  }

  /** 
   * Returns a boolean to know if the index i correspond to a GooseCell index
   * @param i the index to check
   * @return true if it's a GooseCell index, false otherwise
   */
  protected boolean isGooseCell(int i) {
    return i==9 || i==18 || i==27 || i==36 || i==45 || i==54;
  }

  /** 
   * Retuns a boolean to know if the index i correspond to a PrisonCell index
   * @param i the index to check
   * @return true if it's a PrisonCell index, false otherwise
   */
  protected boolean isPrisonCell(int i) {
    return i==31 || i==52;
  }

  /** 
   * Returns a boolean to know if the index i correspond to a WaitCell index
   * @param i the index to check
   * @return true if it's a WaitCell index, false otherwise
   */
  protected boolean isWaitCell(int i) {
    return i==19;
  }

  /** 
   * Returns a boolean to know if the index i correspond to a TeleportCell index
   * @param i the index to check
   * @return true if it's a TeleportCell index, false otherwise
   */
  protected boolean isTeleportCell(int i) {
    return i==6 || i==42 || i==58;
  }
  
}
