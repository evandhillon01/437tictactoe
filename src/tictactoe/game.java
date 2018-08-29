package tictactoe;

//contains all the win checks / methods
// 
public class game {
	int turn = 1;
	board myBoard = new board();
	
	public void play() {
		
		switch(turn) {
		case 1:
			
			if(checkWin()) {
				
				//call board.win(turn)
			}
			turn = 2;
			break;
		case 2:
			
			if(checkWin()) {
				
				//call board.win(turn)
			}
			turn = 3;
			break;
		case 3:
			
			if(checkWin()) {
				
				//call board.win(turn)
			}
			turn = 1;
			break;
		}
		

		return; 
	}
	
	public static boolean checkWin() {
		for(int i = 0; i < myBoard.board.length; i++) {
			for(int j = 0; j < myBoard.board[0].length; i++) {
				
				//horizontal checks
				if(myBoard.board[0][j].piece.player == myBoard.board[1][j].piece.player && myBoard.board[1][j].piece.player == myBoard.board[2][j].piece.player) {
					return true;
				}
				if(myBoard.board[1][j].piece.player == myBoard.board[2][j].piece.player && myBoard.board[2][j].piece.player == myBoard.board[3][j].piece.player) {
					return true;
				}
				
				//vertical checks
				if(myBoard.board[i][0].piece.player == myBoard.board[i][1].piece.player && myBoard.board[i][1].piece.player == myBoard.board[i][2].piece.player) {
					return true;
				}
				if(myBoard.board[i][1].piece.player == myBoard.board[i][2].piece.player && myBoard.board[i][2].piece.player == myBoard.board[i][3].piece.player) {
					return true;
				}
				
				//diagonal checks
				if(i != 0 && i != 4 && j != 0 && j != 4) {
					//diagonal checks \ direction
					if(myBoard.board[i-1][j+1].piece.player == myBoard.board[i][j].piece.player && myBoard.board[i][j].piece.player == myBoard.board[i+1][j-1].piece.player) {
						return true;
					}
					//diagonal checks / direction
					if(myBoard.board[i-1][j-1].piece.player == myBoard.board[i][j].piece.player && myBoard.board[i][j].piece.player == myBoard.board[i+1][j+1].piece.player) {
						return true;
					}
				}		
			}
		}
		myBoard[]
	}
	
}
