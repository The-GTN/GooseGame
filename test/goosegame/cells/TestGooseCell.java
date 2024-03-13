package goosegame.cells;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import goosegame.*;

public class TestGooseCell extends TestCell {

	protected Cell createCell() {
	 	return new GooseCell(0);
 	}


	@Test
	public void testEffect() {
		assertEquals(4,this.cell.effect(4));
		assertEquals(3,this.cell.effect(3));
		assertFalse(4 == this.cell.effect(1));
	}


  // ---Pour permettre l'execution des tests ----------------------
	public static junit.framework.Test suite() {
		return new junit.framework.JUnit4TestAdapter(goosegame.cells.TestGooseCell.class);
	}

}
