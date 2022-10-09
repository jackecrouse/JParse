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
		System.out.println(stringDoc + "\n" + "-----------------");
		
	}
	
	catch (Exception ex) {
		ex.printStackTrace();
	}
	
	String[] lines = stringDoc.split("\n");
	for (String line: lines) {
		//checks if contains href and (https or http)
		if(line.contains("href") && (line.contains("https") || line.contains("http"))) {
			//System.out.println(line);
			if(line.contains("href=")){ line = line.split("href=")[1];}
			if(line.contains("\"")){ line = line.split("\"")[1];}
			
			arr.add(line);
		}
	}
	return arr;
}
}


