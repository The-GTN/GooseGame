package goosegame.cells;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import goosegame.*;

public class TestStartCell extends TestCell {

	protected Cell createCell() {
		return new StartCell();
	}

	@Test
  public void testFreeOrNot() {
    assertTrue(this.cell.isFree());
    this.cell.setPlayer(this.player);
    assertTrue(this.cell.isFree());
    this.cell.clean();
    assertTrue(this.cell.isFree());
  }
	
	@Test
	public void testEffect() {
		assertEquals(0,this.cell.effect(99));
	}

	@Test
	  public void testGetPlayer() {
	    this.cell.setPlayer(this.player);
	    assertEquals(this.player,this.cell.getPlayer());
	    this.cell.clean();
	  }
	
  // ---Pour permettre l'execution des tests ----------------------
	public static junit.framework.Test suite() {
		return new junit.framework.JUnit4TestAdapter(goosegame.cells.TestStartCell.class);
	}

}
