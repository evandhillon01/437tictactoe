package tictactoe;

import java.awt.Color;

public class board {
	public piece [][] pieces;
	int MIN,MAX,size,turns;
	public board(int size){
		pieces = new piece[size][size];
		this.size = size;
		MIN = 0;
		MAX = 1;
		turns = 0;
		this.setup();
	}
	public void setup(){
		StdDraw.setPenColor(Color.BLACK);
		StdDraw.setScale(MIN, MAX);
		this.drawBoard();
	}

	public void turn(int player){
		this.addPiece(player);
		StdDraw.clear();
		this.drawBoard();
		this.drawPieces();
	}
	private void drawBoard(){
		double interval = 1.0/(size);
		double x1=0,x2=1;
		double y1=0, y2=0;
		for (int i=0; i<size-1;i++){
			y1+=interval;
			y2+=interval;
			StdDraw.line(x1, y1, x2, y2);
			StdDraw.line(y1, x1, y2, x2);
		}
	}
	private void drawPieces(){
		for(int row = 0; row<size;row++){
			for(int col=0;col<size;col++){
				if(pieces[row][col]!= null){
					pieces[row][col].draw(indexToCoordinate(col),indexToCoordinate(row));
				}
			}
		}
	}
	public void win(int player){
		StdDraw.clear();
		for(int i=0;i<=360;i=i+15){
			StdDraw.clear();
			StdDraw.setPenColor(genRandomColor());
			StdDraw.text(.5, .5, "Player"+player+" Wins!", i);
			StdDraw.show(50);
		}
	}
	public boolean isFull(){
		return (this.turns >= 9);
	}
	private void addPiece(int player){
		double x=0,y=0;
		int row=-1,col=-1;
		while(true){
			while (!StdDraw.mousePressed()){
				StdDraw.pause(100);
			}
			while(StdDraw.mousePressed()){
				x=StdDraw.mouseX();
				y=StdDraw.mouseY();
			}
			int[] coords = getBoxFromCoordinate(x, y);
			row = coords[0];
			col = coords[1];
			if (isValidMove(row, col)){
				pieces[row][col] = new piece(player);
				turns++;
				return;
			}
		}
	}


	private boolean isValidMove(int row, int col){
		if (pieces[0].length <= col || pieces.length <=row) return false;
		else return pieces[row][col] == null;
	}
	private int[] getBoxFromCoordinate(double x, double y){
		int row = (int)(y / (1.0/size));
		int col = (int)(x / (1.0/size));
		return new int[] {row,col};
	}
	private static Color genRandomColor() {
		return new Color((int)(Math.random()*256), (int)(Math.random()*256), (int)(Math.random()*256));
	}
	public double indexToCoordinate(int index){
		double interval = 1.0/(2*size);
		return (interval * (index*2+1)); //get center of given row/col
	}
	public static void main(String[] args){
		// for testing purposes
		board b = new board(3);
		b.turn(2);
		b.turn(1);
		b.turn(3);
	}	
}
