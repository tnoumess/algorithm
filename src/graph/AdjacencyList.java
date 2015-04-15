/**
 * 
 */
package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Thierry Edson Noumessi
 *
 * @date Apr 9, 2015
 * @12:29:25 AM
 * @AdjacencyList.java
 */
public class AdjacencyList {
	
	private Map<String, Map<String,Integer>> AL;
	
	
	/**
	 * 
	 */
	public AdjacencyList() {
		// TODO Auto-generated constructor stub
		AL=new HashMap<String, Map<String,Integer>>();
	}
	
	public void add(String vertex, Map<String,Integer> list){
		
		if(!AL.containsKey(vertex)){
			
			AL.put(vertex, list);
			
		}	
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AdjacencyList a=new AdjacencyList();
		
		Map<String, Integer> m=new HashMap<String,Integer>();
		m.put("Dallas", 200);
		m.put("Houston", 160);
		
		Map<String, Integer> m2=new HashMap<String,Integer>();
		m2.put("Austin", 200);
		m2.put("Denver", 160);
		
		a.add("Austin", m);
		
		a.add("Dallas", m2);
		

	}

}
