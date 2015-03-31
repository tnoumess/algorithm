package graph;

/**
 * @author Thierry Edson Noumessi
 *
 * @date Mar 31, 2015
 * @1:10:34 AM
 * @Graph.java
 */


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Graph implements Cloneable{
	
	List<Vertex> verticies;
	List<Edge> edges;
	Vertex rootvertex;
	
	Graph(){
		this.verticies=new ArrayList<Vertex>();
		this.edges=new ArrayList<Edge>();	
		this.rootvertex=null;
	}
	
	public boolean addvertex(Vertex v){
		boolean added = false;
	    if (verticies.contains(v) == false) {
	      added = verticies.add(v);
	    }
	    return added;
		
	}
	public boolean addedge(Edge v){
		boolean added = false;
	    if (edges.contains(v) == false) {
	      added = edges.add(v);
	    }
	    return added;
		
	}
	
	public void setRootVertex(Vertex root) {
	    this.rootvertex = root;
	    if (verticies.contains(root) == false)
	      this.addvertex(root);
	  }
	
	
	
	public void visit(Vertex v){
		
		System.out.println("visited:" +v.getName());
				
	}
	
	public  void BFS() throws CloneNotSupportedException{
		
		Graph g=new Graph();
		g=(Graph) this.clone();
		System.out.println(this==g);
		if(g.rootvertex==null){
			return;
		}
		Queue<Vertex> q=new LinkedList<Vertex>();
		
		visit(g.rootvertex);
		g.rootvertex.setVisited(true);
		q.add(g.rootvertex);
		//System.out.println(this.rootvertex.equals(q.peek()));
		while(!q.isEmpty()){
			//System.out.println("queue size="+q.size());
			Vertex v=q.peek();
			
			System.out.println("outter size="+v.outE.size());
		
			q.remove();
			
			for(int i=0;i<=v.outE.size()-1;i++){
				Vertex vv=v.outE.get(i).to;
				if(!vv.isVisited()){
					System.out.println(i);
					visit(vv);
					vv.setVisited(true);
				    
					q.add(vv);
					System.out.println("size q="+q);
				}
			}
			
			
		}
		
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Graph [verticies=" + verticies.toString() + ", edges=" + edges.toString()
				+ ", rootvertex=" + rootvertex + "]";
	}
	
	

	/* (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	public static void main(String[] args) throws CloneNotSupportedException {
		// TODO Auto-generated method stub
     Graph g=new Graph();
    Vertex v1=new Vertex("Austin",new ArrayList<Edge>(),new ArrayList<Edge>(),false);
    Vertex v2=new Vertex("Dallas",new ArrayList<Edge>(),new ArrayList<Edge>(),false);
    Vertex v3=new Vertex("Chicago",new ArrayList<Edge>(),new ArrayList<Edge>(),false);
    Vertex v4=new Vertex("Denver",new ArrayList<Edge>(),new ArrayList<Edge>(),false);
    Vertex v5=new Vertex("Houston",new ArrayList<Edge>(),new ArrayList<Edge>(),false);
    Vertex v6=new Vertex("Atlanta",new ArrayList<Edge>(),new ArrayList<Edge>(),false);
    Vertex v7=new Vertex("Washington",new ArrayList<Edge>(),new ArrayList<Edge>(),false);
    
    Edge e1=new Edge(200,v1,v2,false);
    Edge e2=new Edge(200,v2,v1,false);
    Edge e3=new Edge(160,v1,v5,false);
    Edge e4=new Edge(900,v2,v3,false);
    Edge e5=new Edge(1000,v3,v4,false);
    Edge e6=new Edge(1000,v4,v3,false);
    Edge e7=new Edge(780,v2,v4,false);
    Edge e8=new Edge(1400,v4,v6,false);
    Edge e9=new Edge(800,v5,v6,false);
    Edge e10=new Edge(800,v6,v5,false);
    Edge e11=new Edge(600,v7,v6,false);
    Edge e12=new Edge(600,v6,v7,false);
    Edge e13=new Edge(1300,v7,v2,false);
    v1.addedgein(e2);v1.addedgeout(e1);v1.addedgeout(e3);
    v2.addedgein(e1);v2.addedgein(e13);v2.addedgeout(e2);v2.addedgeout(e4);v2.addedgeout(e7);
    v3.addedgein(e4);v3.addedgein(e6);v3.addedgeout(e5);
    v4.addedgein(e5);v4.addedgein(e7);v4.addedgeout(e6);v4.addedgeout(e8);
    v5.addedgein(e3);v5.addedgein(e10);v5.addedgeout(e9);
    v6.addedgein(e9);v6.addedgein(e8);v6.addedgein(e11);v6.addedgeout(e10);v6.addedgeout(e12);
    v7.addedgein(e12);v7.addedgeout(e13);v7.addedgeout(e12);
    g.addvertex(v1);g.addvertex(v2);g.addvertex(v3);g.addvertex(v4);g.addvertex(v5);
    g.addvertex(v6);g.addvertex(v7);
    g.addedge(e1); g.addedge(e2); g.addedge(e3); g.addedge(e4); g.addedge(e5); g.addedge(e6);
    g.addedge(e7); g.addedge(e8); g.addedge(e9); g.addedge(e10); g.addedge(e11); g.addedge(e12);
    g.addedge(e13);
    g.setRootVertex(v1);
    g.BFS();
System.out.println(g.toString());
	}

}
