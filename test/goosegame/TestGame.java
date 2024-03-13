package goosegame;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import goosegame.boards.ClassicalBoard;
import goosegame.cells.*;
import goosegame.cells.Cell;

public class TestGame {

  protected Game game;
  protected Board board;

  @Before
  public void init() {
    this.board = this.createBoard();
    this.game = this.createGame(this.board);
  }

  protected Board createBoard() {
	  return new ClassicalBoard();
  }

  protected Game createGame(Board board) { 
	  return new Game(board);
  
  }

  @Test
  public void testGetSetPlayers() {
    assertEquals(0,this.game.getPlayers().size());
    this.game.addPlayer(new Player("test1"));
    assertEquals(1,this.game.getPlayers().size());
    this.game.addPlayer(new Player("test2"));
    assertEquals(2,this.game.getPlayers().size());
  }

  @Test
  public void testGetBoard() {
    assertEquals(this.board.getNbOfCells(),this.game.getBoard().getNbOfCells());
  }

  @Test
  public void testIsWin() {
    assertFalse(this.game.isWin());
    this.game.getBoard().getCell(this.game.getBoard().getNbOfCells()).setPlayer(new Player("test"));
    assertTrue(this.game.isWin());
  }

  @Test
  public void testIsStuckandReset() {
    assertTrue(this.game.isStuck());
    Player player = new Player("test");
    this.game.addPlayer(player);
    PrisonCell thecell = (PrisonCell) this.board.getCell(31);
    assertFalse(thecell == null);
    assertFalse(this.game.isStuck());
    if(thecell!=null){
      player.getCell().clean();
      player.setCell(thecell);
      thecell.setPlayer(player);
      assertTrue(this.game.isStuck());
      this.game.resetGame();
      assertFalse(this.game.isStuck());
    }
  }


  @Test
  public void testDepassementPlayers() {
	  Player p = new Player("test1");
	  Cell prev = this.board.getCell(this.board.getNbOfCells()-1);
	  prev.setPlayer(p);
	  p.setCell(prev);
	  this.game.movePlayer(p,2);
	  Cell next = p.getCell();
	  assertEquals(prev,next);
  }
  
  // ---Pour permettre l'execution des tests ----------------------
	public static junit.framework.Test suite() {
		return new junit.framework.JUnit4TestAdapter(goosegame.TestGame.class);
	}

}
