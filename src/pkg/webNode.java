package pkg;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class webNode {
	Queue<String> links = new LinkedList<String>();
	
	public webNode(Queue<String> newQueue) {
		links = newQueue;
	}

	
	public Queue<String> followLink(String URL, String keyWord) {

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
		Queue<String> newQ = new LinkedList<String>();
		newQ.addAll(arr);
		
		//new webnode will be init by a method in webtree
		return newQ;
	}
	public Queue<String> getQueue() {
		return links;
	}
	
	public String dequeue() {
		return links.remove();
	}
	
	public void fillQueue(Queue<String> newQueue) {
		links = newQueue;
	}
}
