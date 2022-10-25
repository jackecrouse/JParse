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
	
	//---------------Antiquated code-------------------
	public webNode followBranch(webNode oldNode) {
		if (oldNode.dequeue() == null) {
			return null;
		}
		String URL = oldNode.dequeue();
		Queue<String> newQueue = JParse.followLink(URL, keyWord);
		webNode newNode = new webNode(newQueue);
		return newNode;
	}
	//-------------------------------------------------
	
	
	public void updateMaster(Queue<String> q) {
		masterList.addAll(q);
	}
	
	public Set<String> getMasterList(){
		return masterList;
	}
	
	@SuppressWarnings("unchecked")
	public void recurTrav(webNode node){
		updateMaster(node.getQueue());
		for(Object url: node.getQueue()) {
			if(!(masterList.contains(url))) {
				webNode newNode = new webNode((Queue<String>)JParse.followLink((String)url, keyWord));
				recurTrav(newNode);
			}
		}
		return;
	}
}
