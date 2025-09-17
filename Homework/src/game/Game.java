// Author: Aiden J. Ewan
// ID: 100 211 3748

package game;
import java.util.Random;
import java.util.Scanner;

public class Game {
	static Scanner kb = new Scanner(System.in);
	public static int RANGE = 10;
	public static void main(String[] args) {
		// Create and fill the game board
		Point[][] gameboard = new Point[10][10];
		initializeBoard(gameboard);
		// Set initial variables and run the game loop
		boolean gameOn = true;
		int playerX = 0;
		int playerY = 0;
		Point player = gameboard[playerX][playerY];
		System.out.println("Welcome to pothole driving! Get home while avoiding potholes!\n");
		while(gameOn) {
			printBoard(gameboard);
			move(playerX, playerY, gameboard, player);
			// Update x and y
			playerX = player.getX();
			playerY = player.getY();
			// Check to see if the player has hit a pothole; if so, ask if they want to retry the game
			if(gameboard[playerX][playerY].isPothole()) {
				System.out.println("You hit a pothole, game over!");
				System.out.print("Would you like to try again? (y/n): ");
				kb.nextLine();
				String answer = kb.nextLine();
				if(answer.equals("n")) {
					gameOn = false;
				} else if(answer.equals("y")) {
					initializeBoard(gameboard);
					playerX = 0;
					playerY = 0;
					player = gameboard[playerX][playerY];
				}
			}
			// Check to see if the player has successfully reached home; if so, ask if they want to retry the game
			if(gameboard[playerX][playerY].isHome()) {
				System.out.println("You made it home, congratulations!");
				System.out.print("Would you like to try again? (y/n): ");
				kb.nextLine();
				String answer = kb.nextLine();
				if(answer.equals("n")) {
					gameOn = false;
				} else {
					initializeBoard(gameboard);
					playerX = 0;
					playerY = 0;
					player = gameboard[playerX][playerY];
				}
			}
			

	}
		kb.close();
}
	
	// Create and fill a gameboard with Points
	public static void initializeBoard(Point[][] gameboard) {
		Random r = new Random();
		for(int x = 0; x < 10; x++) {
			for(int y = 0; y < 10; y++) {
				gameboard[x][y] = new Point('_');
			}
		}
		// Set the player in the top left and home in the bottom right
		gameboard[0][0].setPlayer();
		gameboard[9][9].setHome();
		// Set 5 random potholes
		int potholeCounter = 0;
		while(potholeCounter < 5) {
			int x = r.nextInt(RANGE);
			int y = r.nextInt(RANGE);
			if(!gameboard[x][y].isPothole() && !gameboard[x][y].isPlayer() && !gameboard[x][y].isHome()) {
				gameboard[x][y].setPothole();
				potholeCounter++;
			}
		}
	}
	// Print each Point in a 10 x 10 grid
	public static void printBoard(Point[][] arr) {
		for(Point[] row : arr) {
			for(Point point : row) {
				point.print();
			}
			System.out.println();
		}
	}
	
	// Move the player from one point to another within one unit
	public static void move(int x, int y, Point[][] game, Point p) {
		boolean validMove = false;
		// Temp variables to update the previous point
		int oldX = 0;
		int oldY = 0;
		// Repeat until the move is within the bounds of the grid
		while(!validMove) {
			System.out.print("Type 1, 0, or -1 in the x-direction: ");
			int xDirection = kb.nextInt();
			System.out.print("Type 1, 0, or -1 in the y-direction: ");
			int yDirection = kb.nextInt();
			// Set the new x
			switch(xDirection) {
			case 1:
				if(x - 1 >= 0) {
					oldX = x;
					x--;
					p.setX(x);
					validMove = true;
					break;
				} else {
					System.out.println("Invalid move!");
					break;
				}
			case -1:
				if(x + 1 < 10) {
					oldX = x;
					x++;
					p.setX(x);
					validMove = true;
					break;
				} else {
					System.out.println("Invalid move!");
					break;
				}
			case 0:
				oldX = x;
			}
			// Set the new y
			switch(yDirection) {
			case -1:
				if(y - 1 >= 0) {
					oldY = y;
					y--;
					p.setY(y);
					validMove = true;
					break;
				} else {
					System.out.println("Invalid move!");
					break;
				}
			case 1:
				if(y + 1 < 10) {
					oldY = y;
					y++;
					p.setY(y);
					validMove = true;
					break;
				} else {
					System.out.println("Invalid move!");
					break;
				}
			case 0:
				oldY = y;
			}
		}
		// Update the old and the new Points accordingly
		game[oldX][oldY].setStreet();
		game[x][y].setPlayer();
	}

}
