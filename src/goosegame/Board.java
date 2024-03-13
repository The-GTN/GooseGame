package goosegame;

import java.util.List;
import goosegame.cells.Cell;
import goosegame.cells.StartCell;

/** 
 * Class for the board of GooseGame
 * @author Nollet Antoine Minaud Mathilde
 * @version 23/09/2020
 */
public abstract class Board {
	
	
  /* Number of cells without counting the 0th one */
  protected final int nbOfCells;
  /* The table of the Cells of this Board */
  protected Cell[] theCells;
  
  protected StartCell start;

  /** 
   * Construct a Board
   * @param nbOfCells the number of cells of this Board
   */
  public Board(int nbOfCells) {
    this.nbOfCells = nbOfCells;
    this.initBoard();
    this.start = new StartCell();
  }

  /** 
   * Initialize the cells of this board
   */
  protected abstract void initBoard();

  /** 
   * Returns the cell at index index
   * @param index the index of the cell we want to get
   * @return the cell at index index
   */
  public Cell getCell(int index) {
    return this.theCells[index];
  }

  /** 
   * Returns the number of cells of this board
   * @return the number of cells of this board
   */
  public int getNbOfCells() {
    return this.nbOfCells;
  }

  /** 
   * Clean the board
   */
  public void clean() {
    StartCell cell = this.start;
    while(cell.getPlayers().size() != 0) cell.clean();
    for(int i = 1;i!=this.nbOfCells+1;i++) this.getCell(i).clean();
  }

  /** Move the players of the cell previouscell and nextcell to the other cell (previous to next and next to previous)
  * @param previousCell the first cell
  * @param nextCell the second cell
  */
  public void movePlayers(Cell previousCell, Cell nextCell) {
    Player player1 = previousCell.getPlayer();
    Player player2 = nextCell.getPlayer();
    player1.setCell(nextCell);
    if (player2 != null) player2.setCell(previousCell);
    nextCell.setPlayer(player1);
    previousCell.setPlayer(player2);
  }

  /**
   * Returns the first cell of the game, it had to be a StartCell
   * @return the first cell of the game
   */
  public StartCell getFirstCell(){
	  return this.start;
  }

  /**
   * Returns the landing cell based on its index
   * @param destination the index of destination
   * @return the landing cell
   */
  public Cell getNextCell(int destination){
    int maxCell = this.getNbOfCells();
    if(destination > maxCell){ 
      destination = 2*maxCell - destination;
    }
    return this.getCell(destination);
  }
  
  /**
   * Initialise the player and add it on the start 
   * @param p a player
   */
  public void initPlayer(Player p) {
	  this.start.setPlayer(p);
	  p.setCell(this.start);
  }

  /**
   * Initialise a cell in the grid based on its index, the function will necessary make the 0th cell a StartCell
   * @param index the cell's index
   * @param cell a cell
   */
  protected void initCell(int index, Cell cell) {
  		if(index == 0) { 
  			this.theCells[0] = this.start;
  		}
  		else if(index <= this.nbOfCells) {
  			this.theCells[index] = cell;
  		}
  }
  
}
