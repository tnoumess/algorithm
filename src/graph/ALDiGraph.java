/**
 * Adjacency list of Digraph.
 */
package graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;

/**
 * @author Thierry Edson Noumessi
 *
 * @date Apr 9, 2015
 * @12:29:25 AM
 * @AdjacencyList.java
 */
public class ALDiGraph {
	
	private  int size;
	
	private TreeMap<String, TreeMap<String, Integer>> list;
	/**
	 * Create a Direct Graph Using Adjacency List
	 * @param numberVertices
	 */
	public ALDiGraph() {
		
		list = new TreeMap<String, TreeMap<String,Integer>>();
		this.size = 0;
						 
	}
	
	/**
	 * Add a new edge in the graph by filling out its corresponding vertices
	 * @param from
	 * @param to
	 * @param weight
	 */
	public void addEdge(String from,String to, int weight)
	 {
	 
	 
	 
	 
	 if(list.containsKey(from)){
		 
		 TreeMap<String, Integer> values=list.get(from);
		 values.put(to, weight);
		 list.put(from, values);
		
	 }
	 if(!list.containsKey(from)){
		 size++;
		 TreeMap<String, Integer> h=new TreeMap<String, Integer>();
		 h.put(to, weight);
		 list.put(from, h);
	    }
	 
	 if(!list.containsKey(to)){	
		 size++;
		 list.put(to, new TreeMap<String, Integer>());
	 }
	 
	  }

public String getFirstKey(){
	
	return list.firstKey();
}
	
public void visit(String vertex){
	
	System.out.println(vertex+":visited");
}
/**
 * Breath First Search
 */
public void BFS(){
	if(size==0) return;
	Queue<String> q=new LinkedList<String>();
	HashSet<String> VisitList=new HashSet<String>();
	visit(getFirstKey());
	VisitList.add(getFirstKey());
	q.add(getFirstKey());
	
while(!q.isEmpty()){	
		
		String elt=q.peek();
		q.remove();		
		loop:
		for(Map.Entry<String, TreeMap<String,Integer>> entry: list.entrySet()){
			
			if(entry.getKey()==elt){
				
				TreeMap<String,Integer> tm=entry.getValue();
				for(String key: tm.keySet()){
					if(!VisitList.contains(key)){
						visit(key);
						VisitList.add(key);
						q.add(key);
												
					}
				} break loop;
				
			}
				
		}
	}
	
}

/**
 * Depth First Search
 */
public void DFS(){
	if(size==0) return;
	
	Stack<String> s=new Stack<String>();
	
	s.push(getFirstKey());
	visit(getFirstKey());
	HashSet<String> VisitList=new HashSet<String>();
	VisitList.add(getFirstKey());
	while(!s.empty()){	
		
		String elt=s.peek();
		
		loop:
			for(Map.Entry<String, TreeMap<String,Integer>> entry: list.entrySet()){
			
				if(entry.getKey()==elt){
					
					TreeMap<String,Integer> tm=entry.getValue();
					for(String key: tm.keySet()){
						if(!VisitList.contains(key)){
							elt=key;
							break loop;
						}
					}
					
				}
			}
		if(!VisitList.contains(elt)){
			s.push(elt);
			visit(elt);
			VisitList.add(elt);
		}else{
			
			s.pop();
		}
		
		
	}
}

	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ALDiGraph [Size=" + size + ", list=" + list.toString() + "]";
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		ALDiGraph adg=new ALDiGraph();
		adg.addEdge("Austin", "Dallas",200);
		adg.addEdge("Austin", "Washington",160);
		adg.addEdge("Dallas", "Austin",200);
		adg.addEdge("Dallas", "Denver",780);
		adg.addEdge("Dallas", "Chicago",900);
		adg.addEdge("Denver", "Chicago",1000);
		adg.addEdge("Denver", "Atlanta",1400);
		adg.addEdge("Atlanta", "Washington",800);
		adg.addEdge("Atlanta", "Houston",600);
		adg.addEdge("Houston", "Atlanta",600);
		adg.addEdge("Washington", "Atlanta",800);
		adg.addEdge("Houston", "Dallas",1300);
		adg.addEdge("Chicago", "Denver",1000);
		
		System.out.println(adg.toString());
		adg.BFS();
		System.out.println();
		adg.DFS();
	}

}
