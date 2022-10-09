package pkg;

import java.util.ArrayList;

public class main {
	
	public static void main(String args[]) {
		String URL = "https://www.programiz.com/java-programming/examples/passing-method-as-argument";
		JParse p = new JParse();
		ArrayList<String> arr = p.parseLinks(URL);
		for(String str : arr) {
			System.out.println(str);
		}
	}
}
