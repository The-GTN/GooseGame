package goosegame.cells;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import goosegame.*;

public class TestClassicalCell extends TestCell {
	
	protected Cell createCell() {
		return new ClassicalCell(0);
	}
	
	
	  
	  @Test
		public void testEffect() {
			assertEquals(0,this.cell.effect(99));
		}


	  // ---Pour permettre l'execution des tests ----------------------
		public static junit.framework.Test suite() {
			return new junit.framework.JUnit4TestAdapter(goosegame.cells.TestClassicalCell.class);
		}
}
