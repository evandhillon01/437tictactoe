package tictactoe;

import java.awt.Color;


public class board {
	piece [][] pieces;
	int MIN,MAX,size;
	public board(int size){
		pieces = new piece[size][size];
		this.size = size;
		MIN = 0;
		MAX = 1;
	}
	public void setup(){
		StdDraw.setPenColor(Color.BLACK);
		StdDraw.setScale(MIN, MAX);
	}
//	public void draw(){
//		StdDraw.clear();
//		drawBoard();
//		drawPieces();
//	}
	public void drawBoard(){
		double interval = 1.0/(size);
		double x1=0,x2=1;
		double y1=0, y2=0;
		for (int i=0; i<size-1;i++){
			y1+=interval;
			y2+=interval;
			StdDraw.line(x1, y1, x2, y2);
			StdDraw.line(y1, x1, y2, x2);
		}
		addPiece(1);
	}
	private void drawPieces(){
		for(int row = 0; row<size;row++){
			for(int col=0;col<size;col++){
				pieces[row][col].draw(row,col);
			}
		}
	}
	public void win(int player){
		//clear board announce winner
	}
	public void addPiece(int player){
		double x=0,y=0;
		while (!StdDraw.mousePressed()){
			StdDraw.pause(100);
		}
		while(StdDraw.mousePressed()){
			System.out.println("pressed!");
			x=StdDraw.mouseX();
			y=StdDraw.mouseY();
		}
		int[] coords = getBoxFromCoordinate(x, y);
		pieces[coords[0]][coords[1]] = new piece(player);
	}
	private boolean isValidMove(int x, int y){return true;}
	private int[] getBoxFromCoordinate(double x, double y){
		int row = (int)(y / (1.0/size));
		int col = (int)(x / (1.0/size));
		System.out.println("Row is :"+row+" Col is: "+col);
		return new int[] {row,col};
	}
	
	public static void main(String[] args){
		board b = new board(3);
//		while(true){
//			b.drawBoard();
//		}
	}

	
}
