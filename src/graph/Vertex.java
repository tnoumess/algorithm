package graph;

/**
 * @author Thierry Edson Noumessi
 *
 * @date Mar 31, 2015
 * @1:11:35 AM
 * @Vertex.java
 */


import java.util.ArrayList;
import java.util.List;


public class Vertex{
	String name;
	List<Edge> outE;
	List<Edge> inE;
	boolean visited;
	
		Vertex(){				
			this.name=null;
			this.outE=new ArrayList<Edge>();
			this.inE=new ArrayList<Edge>();
			this.visited=false;
		}
		
		
		public boolean addedgeout(Edge e){
			boolean added = false;
		    if (outE.contains(e) == false) {
		      added = outE.add(e);
		    }
		    return added;
		}
		
		public boolean addedgein(Edge e){
			boolean added = false;
		    if (inE.contains(e) == false) {
		      added = inE.add(e);
		    }
		    return added;
		}

		/**
		 * @return the name
		 */
		public String getName() {
			return name;
		}

		/**
		 * @param name the name to set
		 */
		public void setName(String name) {
			this.name = name;
		}

		/**
		 * @return the visited
		 */
		public boolean isVisited() {
			return visited;
		}

		/**
		 * @param visited the visited to set
		 */
		public void setVisited(boolean visited) {
			this.visited = visited;
		}


		
		public Vertex(String name, List<Edge> outE, List<Edge> inE,
				boolean visited) {
			super();
			this.name = name;
			this.outE = outE;
			this.inE = inE;
			this.visited = visited;
		}


		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "Vertex [name=" + name +"]";
		}


		/* (non-Javadoc)
		 * @see java.lang.Object#hashCode()
		 */
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			result = prime * result + (visited ? 1231 : 1237);
			return result;
		}


		/* (non-Javadoc)
		 * @see java.lang.Object#equals(java.lang.Object)
		 */
		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (obj == null) {
				return false;
			}
			if (!(obj instanceof Vertex)) {
				return false;
			}
			Vertex other = (Vertex) obj;
			if (name == null) {
				if (other.name != null) {
					return false;
				}
			} else if (!name.equals(other.name)) {
				return false;
			}
			if (visited != other.visited) {
				return false;
			}
			return true;
		}


		/*private Graph getOuterType() {
			return Graph.this;
		}*/
		
	
}

