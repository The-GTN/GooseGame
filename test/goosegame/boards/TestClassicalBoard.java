package goosegame.boards;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import goosegame.*;
import goosegame.cells.*;

public class TestClassicalBoard extends TestBoard {

	protected Board createBoard() {
    return new ClassicalBoard();
  }

  @Test
  public void testGetCell() {
    assertEquals(2,this.board.getCell(2).getNumber());
  }
  
  @Test
  public void testGetPrisonCell() {
    assertEquals(true,this.board.getCell(31) instanceof PrisonCell);
  }

  @Test
  public void testGetNbOfCells() {
    assertEquals(63,this.board.getNbOfCells());
  }

  @Test
  public void testClean() {
    this.board.getCell(2).setPlayer(new Player("test1"));
		this.board.getCell(17).setPlayer(new Player("test2"));
		this.board.getCell(52).setPlayer(new Player("test3"));
    assertFalse(this.board.getCell(2).isFree());
		assertFalse(this.board.getCell(17).isFree());
		assertFalse(this.board.getCell(52).isFree());
    this.board.clean();
		assertTrue(this.board.getCell(2).isFree());
		assertTrue(this.board.getCell(17).isFree());
		assertTrue(this.board.getCell(52).isFree());
  }

  @Test
  public void testMovePlayer() {
    this.board.getCell(2).setPlayer(new Player("test"));
    assertFalse(this.board.getCell(2).isFree());
    assertTrue(this.board.getCell(6).isFree());
    this.board.movePlayers(this.board.getCell(2),this.board.getCell(6));
    assertTrue(this.board.getCell(2).isFree());
    assertFalse(this.board.getCell(6).isFree());
  }

  @Test
  public void testMovePlayers() {
    this.board.getCell(10).setPlayer(new Player("test1"));
    this.board.getCell(20).setPlayer(new Player("test2"));
    assertEquals("test1",this.board.getCell(10).getPlayer().toString());
    assertEquals("test2",this.board.getCell(20).getPlayer().toString());
    this.board.movePlayers(this.board.getCell(10),this.board.getCell(20));
    assertEquals("test2",this.board.getCell(10).getPlayer().toString());
    assertEquals("test1",this.board.getCell(20).getPlayer().toString());
  }


  
  // ---Pour permettre l'execution des tests ----------------------
	public static junit.framework.Test suite() {
		return new junit.framework.JUnit4TestAdapter(goosegame.boards.TestClassicalBoard.class);
	}

}
