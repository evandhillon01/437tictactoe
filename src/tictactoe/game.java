package tictactoe;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;
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

	public static void saveGame(board myBoard) throws IOException {
		String fileName = "savedgames.txt";
		String fileStr = "";
		for(int i = 0; i < myBoard.boardPieces[0].length; i++) {
			for(int j = 0; j < myBoard.boardPieces.length; j++) {
				if(myBoard.boardPieces[i][j] != null){
					String numStr = myBoard.boardPieces[i][j].player + ",";
					fileStr = fileStr + numStr;
				}
				else {
					fileStr = fileStr + "x,";
				}
			}
			fileStr = fileStr + "\n";
		}
		PrintWriter clear = new PrintWriter(fileName);
		clear.print("");
		clear.close();
		BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
		writer.write(fileStr);	     
		writer.close();
	}
	
	public static void loadGame(board myBoard) throws IOException {
	    File file = new File("savedgames.txt");
	    BufferedReader reader = new BufferedReader(new FileReader(file));
	    String line;
	    int count = 0;
	    while ((line = reader.readLine()) != null) {
	        String[] values = line.split(",");
	        for(int i = 0; i < values.length; i++) {
	        	if(values[i].equals("x")) {
	        		myBoard.boardPieces[count][i] = null;
	        	}
	        	else if(values[i].equals("1")) {
	        		myBoard.boardPieces[count][i] = new piece(1);
	        	}
	        	else if(values[i].equals("2")) {
	        		myBoard.boardPieces[count][i] = new piece(2);
	        	}
	        	else if(values[i].equals("3")) {
	        		myBoard.boardPieces[count][i] = new piece(3);
	        	}
	        }
	        count++;
	    }
	}
	
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
				if(i != 0 && i != 3 && j != 0 && j != 3) {
					//diagonal checks \ direction
					if(myBoard.boardPieces[i-1][j+1] != null && myBoard.boardPieces[i][j] != null && myBoard.boardPieces[i][j] != null && myBoard.boardPieces[i+1][j-1] != null) {
						if(myBoard.boardPieces[i-1][j+1].player == myBoard.boardPieces[i][j].player && myBoard.boardPieces[i][j].player == myBoard.boardPieces[i+1][j-1].player) {
							return true;
						}
					}
					//diagonal checks / direction
					if(myBoard.boardPieces[i-1][j-1] != null && myBoard.boardPieces[i][j] != null && myBoard.boardPieces[i][j] != null && myBoard.boardPieces[i+1][j+1] != null) {
						if(myBoard.boardPieces[i-1][j-1].player == myBoard.boardPieces[i][j].player && myBoard.boardPieces[i][j].player == myBoard.boardPieces[i+1][j+1].player) {
							return true;
						}
					}
				}	
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

	public static void main(String[] args) throws IOException {
		board myBoard = new board(4);
		play(myBoard);
//		myBoard.boardPieces[2][3] = new piece(2);
//		myBoard.boardPieces[1][3] = new piece(3);
//		myBoard.boardPieces[3][0] = new piece(1);
//		saveGame(myBoard);
//		loadGame(myBoard);
//		System.out.println(myBoard.boardPieces[2][3].player);
//		System.out.println(myBoard.boardPieces[1][3].player);
//		System.out.println(myBoard.boardPieces[3][0].player);
	}
}
