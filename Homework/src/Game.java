import java.util.Random;

public class Game {

	public static int RANGE = 9;
	public static void main(String[] args) {
		char[][] gameboard = new char[10][10];
		for(int x = 0; x < 10; x++) {
			for(int y = 0; y < 10; y++) {
				gameboard[x][y] = '_';
			}
		}

	}

}
