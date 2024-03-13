package goosegame;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public abstract class TestBoard {

  protected Board board;

	@Before
	public void init() {
		this.board = this.createBoard();
	}

	protected abstract Board createBoard();

  public abstract void testGetCell();

  public abstract void testGetNbOfCells();

  public abstract void testClean();

  public abstract void testMovePlayer();

  public abstract void testMovePlayers();


}
