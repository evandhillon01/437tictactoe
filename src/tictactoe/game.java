package tictactoe;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
//contains all the win checks / methods
// 

public class game {
	
	int turn = 1;
	boolean win;
	board myBoard = new board(4);
	
	public void play() {
		while (win != true) {
			switch(turn) {
			case 1:
				
				if(checkWin()) {
					
					//call pieces.win(turn)
				}
				turn = 2;
				break;
			case 2:
				
				if(checkWin()) {
					
					//call pieces.win(turn)
				}
				turn = 3;
				break;
			case 3:
				
				if(checkWin()) {
					
					//call pieces.win(turn)
				}
				turn = 1;
				break;
			}
		}
		
		

		return; 
	}
	
	public void saveGame() throws IOException {
		String fileName = "savedgames.txt";
		String fileStr = "";
		for(int i = 0; i < myBoard.pieces[0].length; i++) {
			for(int j = 0; j < myBoard.pieces.length; j++) {
				String numStr = myBoard.pieces[i][j].player + ",";
				fileStr = fileStr + numStr;
			}
			fileStr = fileStr + "\n";
		}
		BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
		writer.append(fileStr);	     
		writer.close();
	}
	
	public void loadGame() {
		
	}
	
	public boolean checkWin() {
		for(int i = 0; i < myBoard.pieces.length; i++) {
			for(int j = 0; j < myBoard.pieces[0].length; i++) {
				
				//horizontal checks
				if(myBoard.pieces[0][j].player == myBoard.pieces[1][j].player && myBoard.pieces[1][j].player == myBoard.pieces[2][j].player) {
					return true;
				}
				if(myBoard.pieces[1][j].player == myBoard.pieces[2][j].player && myBoard.pieces[2][j].player == myBoard.pieces[3][j].player) {
					return true;
				}
				
				//vertical checks
				if(myBoard.pieces[i][0].player == myBoard.pieces[i][1].player && myBoard.pieces[i][1].player == myBoard.pieces[i][2].player) {
					return true;
				}
				if(myBoard.pieces[i][1].player == myBoard.pieces[i][2].player && myBoard.pieces[i][2].player == myBoard.pieces[i][3].player) {
					return true;
				}
				
				//diagonal checkss
				if(i != 0 && i != 4 && j != 0 && j != 4) {
					//diagonal checks \ direction
					if(myBoard.pieces[i-1][j+1].player == myBoard.pieces[i][j].player && myBoard.pieces[i][j].player == myBoard.pieces[i+1][j-1].player) {
						return true;
					}
					//diagonal checks / direction
					if(myBoard.pieces[i-1][j-1].player == myBoard.pieces[i][j].player && myBoard.pieces[i][j].player == myBoard.pieces[i+1][j+1].player) {
						return true;
					}
				}		
			}
		}
		return false;
	}
	
}
