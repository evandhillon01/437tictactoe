package tictactoe;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
//contains all the win checks / methods 

public class game {
	
	static int turn = 1;
	static boolean win;
	
/**
 * Plays the game Tic-Tac-Toe
 * @param myBoard the instance of the game
 */
	public static void play(board myBoard) {
			int player = 1;
		while (win == false) {
			myBoard.addPiece(player);
			if(!checkWin(myBoard)) {
				win = checkWin(myBoard);
			};
			turn ++;
			player = (turn % 3);
			if (player == 0) {
				player = 3;
			}
		}
		win(player);
		return; 
	}


//commented to get basic functioning first.
//	public void saveGame(board myBoard) throws IOException {
//		String fileName = "savedgames.txt";
//		String fileStr = "";
//		for(int i = 0; i < myBoard.pieces[0].length; i++) {
//			for(int j = 0; j < myBoard.pieces.length; j++) {
//				String numStr = myBoard.pieces[i][j].player + ",";
//				fileStr = fileStr + numStr;
//			}
//			fileStr = fileStr + "\n";
//		}
//		BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
//		writer.append(fileStr);	     
//		writer.close();
//	}
	
//	public void loadGame() {
//		
//	}
	
	// FIX: Logic needs to be cleaned. In more modular way, check for NULL then check for win.
	public static boolean checkWin(board myBoard) {
		for(int i = 0; i < myBoard.boardPieces.length; i++) {
			System.out.println("i = " + i);
			System.out.println("i piece =" + myBoard.boardPieces[i]);
			if(myBoard.boardPieces[i] == null) {
				continue;
			}

			for(int j = 0; j < myBoard.boardPieces[i].length; j++) {
				System.out.println("j = " + j);
				System.out.println("j piece =" + myBoard.boardPieces[i][j]);
				if(myBoard.boardPieces[i][j] == null) {
					continue;
				}

				//horizontal checks
				if(myBoard.boardPieces[0][j] != null && myBoard.boardPieces[1][j] != null && myBoard.boardPieces[2][j] != null ) { 
					if(myBoard.boardPieces[0][j].player == myBoard.boardPieces[1][j].player && myBoard.boardPieces[1][j].player == myBoard.boardPieces[2][j].player) {
						return true;
					}
				}
				if(myBoard.boardPieces[3][j] != null && myBoard.boardPieces[1][j] != null && myBoard.boardPieces[2][j] != null ) { 
					if(myBoard.boardPieces[1][j].player == myBoard.boardPieces[2][j].player && myBoard.boardPieces[2][j].player == myBoard.boardPieces[3][j].player) {
						return true;
					}
				}
				
				//vertical checks
				if(myBoard.boardPieces[i][0] != null && myBoard.boardPieces[i][1] != null && myBoard.boardPieces[i][2] != null ) { 
					if(myBoard.boardPieces[i][0].player == myBoard.boardPieces[i][1].player && myBoard.boardPieces[i][1].player == myBoard.boardPieces[i][2].player) {
						return true;
					}
				}

				if(myBoard.boardPieces[i][1] != null && myBoard.boardPieces[i][2] != null && myBoard.boardPieces[i][3] != null ) { 
					if(myBoard.boardPieces[i][1].player == myBoard.boardPieces[i][2].player && myBoard.boardPieces[i][2].player == myBoard.boardPieces[i][3].player) {
						return true;
					}
				}
				//edited to get row/col checking first.
				//diagonal checkss
//				if(i != 0 && i != 3 && j != 0 && j != 3) {
//					//diagonal checks \ direction
//					if(myBoard.boardPieces[i-1][j+1].player == myBoard.boardPieces[i][j].player && myBoard.boardPieces[i][j].player == myBoard.boardPieces[i+1][j-1].player) {
//						return true;
//					}
//					//diagonal checks / direction
//					if(myBoard.boardPieces[i-1][j-1].player == myBoard.boardPieces[i][j].player && myBoard.boardPieces[i][j].player == myBoard.boardPieces[i+1][j+1].player) {
//						return true;
//					}
//				}	
			}
		}
		return false;
	}
	
    //FIX: for scaling here. Scale is hard coded
	public static void win(int player){
		StdDraw.clear();
		for(int i = 0; i<= 360 ; i = i+15) {
			StdDraw.clear();
			//StdDraw.setPenColor(genRandomColor());
			StdDraw.text(.5, .5, "Player " + player + "Wins!", i);
			StdDraw.show(50);
		}
	}

	public static void main(String[] args) {
		board myBoard = new board(4);
		play(myBoard);
		}
	}
