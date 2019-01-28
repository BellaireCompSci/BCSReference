package examples;

public class Transformations {
	//assuming rectangle shapes
	public static char[][] rotate90CW(char[][] pic){ //rotate 90 degrees clockwise, aka 270 degrees counter-clockwise
		char[][] t = new char[pic[0].length][pic.length];
		for(int i = 0; i < pic[0].length; i++) {
			for(int j = 0; j < pic.length; j++) {
				t[i][j] = pic[pic.length - j - 1][i];
			}
		}
		return t;
	}
	
	public static char[][] rotate90CCW(char[][] pic){ //rotate 90 degrees counter-clockwise, aka 270 degrees clockwise
		char[][] t = new char[pic[0].length][pic.length]; //could run above method 3 times, but this saves time + is good to know
		for(int i = 0; i < pic[0].length; i++) {
			for(int j = 0; j < pic.length; j++) {
				t[i][j] = pic[j][pic[0].length - i - 1];
			}
		}
		return t;
	}
	
	public static char[][] rotate180(char[][] pic){ //rotate 180 degrees(any direction)
		return rotate90CW(rotate90CW(pic)); //got lazy
	}
	
	public static char[][] flipOverY(char[][] pic){ //flip over the vertical axis
		char[][] t = new char[pic.length][pic[0].length];
		for(int i = 0; i < pic[0].length; i++) {
			for(int j = 0; j < pic.length; j++) {
				t[j][i] = pic[j][pic[0].length - i - 1];
			}
		}
		return t;
	}
	
	public static char[][] flipOverX(char[][] pic){ //flip over the horizontal axis
		char[][] t = new char[pic.length][pic[0].length];
		for(int i = 0; i < pic[0].length; i++) {
			for(int j = 0; j < pic.length; j++) {
				t[j][i] = pic[pic.length - 1 - j][i];
			}
		}
		return t;
	}
}
