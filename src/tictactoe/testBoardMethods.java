package tictactoe;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class testBoardMethods {
	board myBoard = new board(4);

	@Test
	public void testBoxFromCoordinate() {
		int[] result = myBoard.getBoxFromCoordinate(.5, .5);
		int[] correct = new int[] {2,2};
		assertArrayEquals(result, correct);	
	}
	@Test
	public void testBoxFromCoordinateNegative() {
		assertEquals(null, myBoard.getBoxFromCoordinate(-1, -2));
	}
	@Test
	public void testindexToCoordinate() {
		assertEquals(.125, myBoard.indexToCoordinate(0),0.001);
		assertEquals(.375, myBoard.indexToCoordinate(1),0);
		assertEquals(.625, myBoard.indexToCoordinate(2),0.001);
		assertEquals(.875, myBoard.indexToCoordinate(3),0.001);
		
	}
	@Test
	public void testindexToCoordinateOutOfRange() {
		assertEquals(-1, myBoard.indexToCoordinate(4),0);
	}
	@Test
	public void testBoxFromCoordinateOutOfRange() {
		assertEquals(null, myBoard.getBoxFromCoordinate(2, 2));
	}
	@Test
	public void testCheckWinHorizontal(){
		myBoard.boardPieces = new piece[][] {{new piece(1),new piece(1), new piece(1), new piece(0)},
			{null,null,null,null},
			{null,null,null,null},
			{null,null,null,null}};
		assertEquals(game.checkWin(myBoard), true);
	}
	@Test
	public void testCheckWinVertical(){
		myBoard.boardPieces = new piece[][] {{new piece(1),new piece(0), new piece(1), new piece(0)},
			{new piece(1),null,null,null},
			{new piece(1),null,null,null},
			{null,null,null,null}};
		assertEquals(game.checkWin(myBoard), true);
	}
	@Test
	public void testCheckWinDiagonal(){
		myBoard.boardPieces = new piece[][] {{new piece(1),new piece(0), new piece(1), new piece(0)},
			{null,new piece(1),null,null},
			{null,null,new piece(1),null},
			{null,null,null,null}};
		assertEquals(game.checkWin(myBoard), true);
	}
	@Test
	public void testCheckWinFalse(){
		myBoard.boardPieces = new piece[][] {{new piece(2),new piece(0), new piece(1), new piece(1)},
			{null,null,null,null},
			{null,null,null,null},
			{null,null,null,null}};
		assertEquals(game.checkWin(myBoard), false);
	}
	@Test
	public void testCheckWinNull(){
		myBoard.boardPieces = new piece[][] {{null,null,null,null},
			{null,null,null,null},
			{null,null,null,null},
			{null,null,null,null}};
		assertEquals(game.checkWin(myBoard), false);
	}
}
