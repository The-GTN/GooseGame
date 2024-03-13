package goosegame.cells;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import goosegame.*;

public class TestPrisonCell extends TestCell {

	protected PrisonCell prisoncell;

	@Before
	public void init() {
    super.init();
		this.prisoncell = this.createPrisonCell();
	}

	protected Cell createCell() {
	 	return new PrisonCell(0);
 	}


	protected PrisonCell createPrisonCell() {
		return new PrisonCell(0);
	}

	@Test
	public void testEffect() {
		assertEquals(0,this.cell.effect(99));
	}

	@Test
  public void testIsPrison() {
    assertTrue(this.cell.isPrison());
  }

	@Test
	public void testDefinitive() {
		assertTrue(this.prisoncell.isDefinitive());
	}

  // ---Pour permettre l'execution des tests ----------------------
	public static junit.framework.Test suite() {
		return new junit.framework.JUnit4TestAdapter(goosegame.cells.TestPrisonCell.class);
	}

}
