package pkg;

import java.util.ArrayList;
import java.util.LinkedList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class JParse {
	public ArrayList<String> parseLinks(String URL) {
			
			//initializing things outside try/catch
			ArrayList<String> arr = new ArrayList<String>();
			String stringDoc = "";
			
		try {
			//creates doc and turns to string for easy parsing, all below line is products of parsing in print statement
			final Document doc = Jsoup.connect(URL).get();
			stringDoc = doc.outerHtml().toString();
			//System.out.println(stringDoc + "\n" + "-----------------");
			
		}
		
		catch (Exception ex) {
			ex.printStackTrace();
		}
		
		String[] lines = stringDoc.split("\n");
			for (String line: lines) {
			//checks if contains href and (https or http)
				if(line.contains("href") && (line.contains("https") || line.contains("http"))) {
				//parses for href= and takes what's after
					if(line.contains("href=")){ line = line.split("href=")[1];}
				//parse for quotation marks and takes what's in between
					if(line.contains("\"")){ line = line.split("\"")[1];}
				arr.add(line);
				}
			}
			return arr;
		}
	
	public ArrayList<String> parsePhrase(String URL, String phrase){

		//initializing things outside try/catch
		ArrayList<String> arr = new ArrayList<String>();
		String stringDoc = "";
		
		try {
			//creates doc and turns to string for easy parsing, all below line is products of parsing in print statement
			final Document doc = Jsoup.connect(URL).get();
			stringDoc = doc.outerHtml().toString();
			//System.out.println(stringDoc + "\n" + "-----------------");
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		String[] lines = stringDoc.split("\n");
		for (String line: lines) {
		//checks if contains phrase
			if(line.contains(phrase)) {
				arr.add(line);
			}
			
		}
		return arr;
	}
	public static LinkedList followLink(String URL, String keyWord) {

		//initializing things outside try/catch
		ArrayList<String> arr = new ArrayList<String>();
		String stringDoc = "";
		
	try {
		//creates doc and turns to string for easy parsing, all below line is products of parsing in print statement
		final Document doc = Jsoup.connect(URL).get();
		stringDoc = doc.outerHtml().toString();
		//System.out.println(stringDoc + "\n" + "-----------------");
		
	}
	
	catch (Exception ex) {
		ex.printStackTrace();
	}
	
	String[] lines = stringDoc.split("\n");
		for (String line: lines) {
		//checks if contains href and (https or http)
			if(line.contains("href") && (line.contains("https") || line.contains("http"))) {
			//parses for href= and takes what's after
				if(line.contains("href=")){ line = line.split("href=")[1];}
			//parse for quotation marks and takes what's in between
				if(line.contains("\"")){ line = line.split("\"")[1];}
			arr.add(line);
			}
		}
		LinkedList newLL = new LinkedList();
		newLL.addAll(arr);
		
		//new webnode will be init by a method in webtree
		return newLL;
	
	}
}

