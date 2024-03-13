package goosegame;

import goosegame.cells.Cell;
/** 
 * Class for player in the GooseGame
 * @author Nollet Antoine Minaud Mathilde
 * @version 23/09/2020
 */
public class Player {
	
	
    /** current cell of the player */
    protected Cell cell;
    /** name of the player*/
    protected String name;
    /** 
     * @param name the name of this player
     * @param cell the starting cell of this player
    */
    public Player (String name, Cell cell){
        this.name = name;
        this.cell = cell;
    }
    /**  A player with no current cell (== null)
     * @param name the name of this player
     * 
    */
    public Player (String name){
        this(name, null);
    }
    /** */
    public String toString() { return name; }
    
    /** returns the current cell of the player 
      *  @return the current cell of the player 
      */
    public Cell getCell() { 
       return this.cell ; 
    }
    /** changes the cell of the player 
     * @param newCell the new cell
    */
    public void setCell(Cell newCell) { 
       this.cell = newCell; 
    }    
   
}// Player
