
public class Point {
	private boolean player, pothole, home;
	private char symbol;
	
	public Point(boolean isPlayer, boolean isPothole, boolean isHome, char sym) {
		player = isPlayer;
		pothole = isPothole;
		home = isHome;
		symbol = sym;
	}
	
	public boolean isPothole() {
		return pothole;
	}
	
	public void print() {
		System.out.println(symbol);
	}
}
