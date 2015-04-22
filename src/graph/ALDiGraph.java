/**
 * Adjacency list of Digraph.
 */
package graph;

import java.util.HashMap;
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
public class ALDiGraph implements Cloneable{
	
	private  int size;
	
	private HashMap<String,Integer> indegree;
	private TreeMap<String, TreeMap<String, Integer>> list;
	/**
	 * Create a Direct Graph Using Adjacency List
	 * @param numberVertices
	 */
	public ALDiGraph() {
		
		indegree =new HashMap<String, Integer>();
		list = new TreeMap<String, TreeMap<String,Integer>>();
		this.size = 0;
						 
	}
	
	protected Object clone() throws CloneNotSupportedException {
		
		ALDiGraph g=new ALDiGraph();
		
		for(Map.Entry<String, TreeMap<String,Integer>> entry: list.entrySet()){
			g.list.put(entry.getKey(), entry.getValue());
		}
		for(Map.Entry<String, Integer> entry: indegree.entrySet()){
		 g.indegree.put(entry.getKey(), entry.getValue());
			
		}
		g.size=size;
		
		return g;
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
		 indegree.put(from, 0);
		
	    }
	 
	 if(!list.containsKey(to)){	
		 size++;
		 list.put(to, new TreeMap<String, Integer>());
		 
	 }
	 
	 /**
	  * insert indegree for topological sorting purposes
	  */
	 if(indegree.containsKey(to)){	
		 		 
		 indegree.put(to, indegree.get(to)+1);
	 }
	 if(!indegree.containsKey(to)){
		 
		 indegree.put(to, 1);
	 }
	 
	  }

	public void indegreeList(){
		
		System.out.println("indegree:"+indegree.toString());
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

/**
 * Topological sorting
 * @throws CloneNotSupportedException 
 */

public void TopologicalSorting() throws CloneNotSupportedException{
	
	ALDiGraph g= (ALDiGraph) this.clone();
	LinkedList<String> ll=new LinkedList<>();
	while(g.indegree.size()>0){
		
		assert FNVOIZ(g.indegree)!=null: "Cycle found Exception";
		if(FNVOIZ(g.indegree)!=null){
			String st=FNVOIZ(g.indegree);
			ll.add(st);
			
			g.indegree.remove(st);
			
			String[] s=getoutdegree(st, g);
			
			reduceindegree(s, g.indegree);
				
						
		}
	}
	System.out.print("A topological sorting is:"+ll);
	System.out.println("\n"+g.toString());
	
}

/**
 * Decrease the number of edge adjacent to [] s
 * @param s
 * @param hm
 */
private void reduceindegree(String[] s,HashMap<String, Integer> hm){
	
	for( int i = 0; i < s.length ; i++){
		hm.put(s[i],  hm.get(s[i])-1);}
		
}

/**
 * Retrieve the vertices adjacent from st
 * @param st
 * @param ag
 * @return
 */
private String[] getoutdegree(String st,ALDiGraph ag){
	
	String[] s= new String[ag.list.get(st).size()];
	//System.out.println(st+":number of outdegree:"+ag.list.get(st).size());
	int i=0;
	for(Map.Entry<String, TreeMap<String,Integer>> entry: ag.list.entrySet()){
		
		if(entry.getKey()==st){
			TreeMap<String,Integer> tm=entry.getValue();
			for(String key: tm.keySet()){
				s[i]=key;
				i++;
			}
		}
		
	}
	return s;
	
}
/**
 * Find New Vertex Of Indegree Zero
 * @param hs
 * @return
 */
private String FNVOIZ(HashMap<String, Integer> hs){
	
	for(Map.Entry<String, Integer> entry: hs.entrySet()){
		
		if(entry.getValue()==0) return entry.getKey();
	}
	return null;
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
	 * @throws CloneNotSupportedException 
	 */
	public static void main(String[] args) throws CloneNotSupportedException {
		// TODO Auto-generated method stub
	/*		
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
		adg.DFS();*/
		
		ALDiGraph ts=new ALDiGraph();
		ts.addEdge("v1", "v2",200);
		ts.addEdge("v1", "v4",200);
		ts.addEdge("v1", "v3",200);
		ts.addEdge("v2", "v5",200);
		ts.addEdge("v2", "v4",200);
		ts.addEdge("v3", "v6",200);
		ts.addEdge("v4", "v7",200);
		ts.addEdge("v4", "v6",200);
		ts.addEdge("v4", "v3",200);
		ts.addEdge("v5", "v7",200);
		ts.addEdge("v5", "v4",200);
		ts.addEdge("v7", "v6",200);
		ts.indegreeList();
		ts.TopologicalSorting();
		//ts.indegreeList();
	}

}
