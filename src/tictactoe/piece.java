package tictactoe;

public class piece {
	int player;
	public piece(int player){
		this.player = player;
	}
	public void draw(int row, int col){
		switch(player){
		case 1:
			//draw X
			break;
		case 2:
			//draw O
			break;
		case 3:
			//draw Triangle
			break;
		}
		
	}
	
}
