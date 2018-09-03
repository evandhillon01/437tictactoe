package tictactoe;

import java.awt.Color;

public class board {

	int boardDim; 
	piece[][] boardPieces;
	/**
	 * Constuctor for board
	 * @param boardDim n size for nxn board
	 */
	public board (int boardDim) {
		this.boardDim = boardDim;
		this.boardPieces = new piece[boardDim][boardDim];
		//need turn count somewhere
		this.setBoard();
	}

/**
 * Sets the default settings for the board.
 * @param boardDim the dimensions of the board of n x n size.
 */
	private void setBoard() {
		StdDraw.setPenColor(Color.BLACK);
		StdDraw.setScale(0,1);
		drawBoard();
	}

/**
 * Draws the board. 
 * @param boardDim the dimensions of the board of n x n size.
 */
	private void drawBoard () {
		double x1 = 0.0, x2 = 1.0;
		double y1 = 0.0, y2 = 0.0;
		
		double interval = 1.0 / (this.boardDim);

		// Draw board lines for the x- and y-a
		for (int i = 0; i < this.boardDim-1; i++) {
			y1 += interval;
			y2 += interval;
			StdDraw.line(x1, y1, x2, y2);
			StdDraw.line(y1, x1, y2, x2);
		}
	}

	/**
	 * Adds piece to the board
	 * @param player the number of the player
	 */
	void addPiece(int player) {
		double x = 0, y = 0;
		int row ,col;			
		double[] coor = clickOnBoard();

		// x is stored in the 0-index and y in the 1-index of returned array
		x = coor[0];
		y = coor[1];
		int[] coorRowAndCol = getBoxFromCoordinate(x, y);
		row = coorRowAndCol[0];
		col = coorRowAndCol[1];
		
		double centerX = indexToCoordinate(col);
		double centerY = indexToCoordinate(row);
		
		if(isValidMove(row,col)) {
			piece addedPiece = new piece(player);
			this.boardPieces[row][col] = addedPiece;
			addedPiece.draw(centerX, centerY);
		}
		else {
			addPiece(player);
		}
	}

/**
 * Registers mouse click on board
 * @return array of x coordinate @ 0-index 
 * 		   and y coordinate @ 1-index
 */
	private double[] clickOnBoard() {
		double x = 0, y = 0;
		double [] coor = new double [2];
		while (!StdDraw.mousePressed()){
			StdDraw.pause(100);
		}
		while(StdDraw.mousePressed()){
			x=StdDraw.mouseX();
			y=StdDraw.mouseY();
		}
		coor[0] = x;
		coor[1] = y;
		return coor;
	}

	/**
	 * 	Checks if user-input is valid move
	 * @param row row of user input
	 * @param col column of user input
	 * @return boolean true if user input is within bounds or board's box is vacant, false if not.
	 */
	private boolean isValidMove(int row, int col){
		if (col >= this.boardPieces[0].length || row >= this.boardPieces.length) {
			return false;
		}
		return this.boardPieces[row][col] == null;
	}

	private static Color genRandomColor() {
		return new Color((int)(Math.random()*256), (int)(Math.random()*256), (int)(Math.random()*256));
	}

	// Helper functions
	/**
	 * Calculates the centered coordinate of an entire row or column.
	 * @param index the row or column number
	 * @return the center of the given row or column
	 */
	private double indexToCoordinate (int index) {
		double interval = 1.0 / (2 * this.boardDim);
		return (interval * (index * 2 + 1));
	}
	/**
	 * 
	 * @param x x-Coordinate
	 * @param y y-Coordinate
	 * @return array with corresponding row and column of coordinates
	 */

	private int[] getBoxFromCoordinate(double x, double y){
		int row = (int) (y / (1.0 / this.boardDim));
		int col = (int) (x / (1.0 / this.boardDim));
		return new int[] {row,col};
	}
}
