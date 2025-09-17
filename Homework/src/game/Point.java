package game;

public class Point {
	private int x, y;
	private boolean player, pothole, home;
	private char symbol;
	
	public Point(char sym) {
		player = false;
		pothole = false;
		home = false;
		symbol = sym;
	}
	
	// Setters
	public void setPothole() {
		pothole = true;
		player = false;
		home = false;
	}
	public void setStreet() {
		symbol = '_';
	}
	public void setPlayer() {
		player = true;
		symbol = 'X';
	}
	public void setHome() {
		home = true;
		player = false;
		pothole = false;
		symbol = '^';
	}
	public void setX(int i) {
		x = i;
	}
	public void setY(int j) {
		y = j;
	}
	
	// Getters
	public boolean isPothole() {
		return pothole;
	}
	public boolean isPlayer() {
		return player;
	}
	public boolean isHome() {
		return home;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	
	// Pretty print
	public void print() {
		System.out.print(symbol);
	}
}
