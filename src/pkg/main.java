package pkg;

import java.util.ArrayList;

public class main {
	
	public static void main(String args[]) {
		String URL = "https://www.youtube.com/watch?v=gsK4nX0tCGQ&t=813s";
		JParse p = new JParse();
		ArrayList<String> arr = p.parseLinks(URL);
		for(String str : arr) {
			System.out.println(str);
		}
	}
}
