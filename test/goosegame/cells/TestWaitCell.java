package goosegame.cells;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import goosegame.*;

public class TestWaitCell extends TestPrisonCell {

	protected Cell createCell() {
	 	return new WaitCell(0,2);
 	}


	protected PrisonCell createPrisonCell() {
		return new WaitCell(0,2);
	}

	@Test
	public void testDefinitive() {
		assertFalse(this.prisoncell.isDefinitive());
	}

	@Test
  public void testIsPrison() {
    assertTrue(this.cell.isPrison());
		assertTrue(this.cell.isPrison());
		assertFalse(this.cell.isPrison());
  }

  // ---Pour permettre l'execution des tests ----------------------
	public static junit.framework.Test suite() {
		return new junit.framework.JUnit4TestAdapter(goosegame.cells.TestWaitCell.class);
	}

}
