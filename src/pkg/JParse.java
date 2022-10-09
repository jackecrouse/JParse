package pkg;

import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class JParse {
	public ArrayList<String> parseLinks(String URL) {
		
		//initializing things outside try/catch
		ArrayList<String> arr = new ArrayList<String>();
		String stringDoc = "";
		
	try {
		
		final Document doc = Jsoup.connect(URL).get();
		stringDoc = doc.outerHtml().toString();
	}
	
	catch (Exception ex) {
		ex.printStackTrace();
	}
	
	String[] lines = stringDoc.split("\n");
	for (String line: lines) {
		if(line.contains("http")) {arr.add(line);};
	}
	return arr;
}
}


