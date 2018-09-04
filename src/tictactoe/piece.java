package tictactoe;

import java.awt.Color;

public class piece {

	public int player;
	double radius;

	public piece(int player) {
		this.player = player;
		//fix for scale here
		this.radius = .1;
	}

/**
 * Draws the piece at specified x- and y-coordinates w/ distinct color
 * @param x x-coordinate to draw piece
 * @param y y-coordinate to draw piece
 */
	public void draw(double x, double y) {
		switch(player) {
			// X player
			case 1:
				StdDraw.setPenColor(Color.RED);
				StdDraw.line(x - radius, y - radius, x + radius, y + radius);
				StdDraw.line(x - radius, y + radius, x + radius, y - radius);
				break;
	
			// O player
			case 2:
				StdDraw.setPenColor(Color.BLUE);
				StdDraw.circle(x, y, radius);
				break;

			// Square player
			case 3:
				StdDraw.setPenColor(Color.GREEN);
				StdDraw.square(x, y, radius);
				break;
		}
		StdDraw.setPenColor(Color.black);
	}
}
