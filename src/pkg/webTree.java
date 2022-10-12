package pkg;

import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class webTree {
	Set<String> masterList = new HashSet<String>();
	String keyWord = "";
	
	public void setKeyWord(String newWord) {
		keyWord = newWord;
	}
	
	public webNode followBranch(webNode oldNode) {
		if (oldNode.dequeue() == null) {
			return null;
		}
		String URL = oldNode.dequeue();
		Queue newQueue = JParse.followLink(URL, keyWord);
		webNode newNode = new webNode(newQueue);
		return newNode;
	}
	
	public void updateMaster(Queue q) {
		masterList.addAll(q);
	}
}
