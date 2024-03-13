package goosegame.cells;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import goosegame.Player;
import goosegame.cells.Cell;

public abstract class TestCell {

  protected Cell cell;
  protected Player player;

	@Before
	public void init() {
    this.cell = this.createCell();
    this.player = new Player("test");
	}

	@Test
	  public void testGetNumber() {
	    assertEquals(0,this.cell.getNumber());
	  }

	  @Test
	  public void testGetPlayer() {
	    this.cell.setPlayer(this.player);
	    assertEquals(this.player.toString(),this.cell.getPlayer().toString());
	    this.cell.clean();
	  }

	  @Test
	  public void testFreeOrNot() {
	    assertTrue(this.cell.isFree());
	    this.cell.setPlayer(this.player);
	    assertFalse(this.cell.isFree());
	    this.cell.clean();
	    assertTrue(this.cell.isFree());
	  }


	  @Test
	  public void testIsPrison() {
	    assertFalse(this.cell.isPrison());
	  }
	protected abstract Cell createCell();
		
	
	public abstract void testEffect();
	

}
