package goosegame.cells;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import goosegame.*;

public class TestTeleportCell extends TestCell {

	protected Cell createCell() {
	 	return new TeleportCell(0,5);
 	}

	@Test
	public void testEffect() {
		assertEquals(5,this.cell.effect(99));
	}

  // ---Pour permettre l'execution des tests ----------------------
	public static junit.framework.Test suite() {
		return new junit.framework.JUnit4TestAdapter(goosegame.cells.TestTeleportCell.class);
	}

}
