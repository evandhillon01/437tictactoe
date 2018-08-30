package tictactoe;

import java.awt.Color;

public class piece {
	int player;
	double size;
	public piece(int player){
		this.player = player;
		this.size = .145;
	}
	public void draw(double x, double y){
		switch(player){
		case 1:
			//draw X
			StdDraw.setPenColor(Color.RED);
			StdDraw.line(x-size, y-size, x+size, y+size);
			StdDraw.line(x-size, y+size, x+size, y-size);
			break;
		case 2:
			// draw O
			StdDraw.setPenColor(Color.BLUE);
			StdDraw.circle(x, y, size);
			break;
		case 3:
			//draw square
			StdDraw.setPenColor(Color.GREEN);
			StdDraw.square(x, y, size);
			break;
		}
		StdDraw.setPenColor(Color.black);
		
	}
	
	
}
