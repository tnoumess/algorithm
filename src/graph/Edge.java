package graph;

/**
 * @author Thierry Edson Noumessi
 *
 * @date Mar 31, 2015
 * @1:12:33 AM
 * @Edge.java
 */




public class Edge{
	int weight;
	Vertex from;
	Vertex to;
	boolean visited;
	
	Edge(){
		this.weight=0;
		from=null;
		to=null;
		visited=false;
	}

	/**
	 * @return the weight
	 */
	public int getWeight() {
		return weight;
	}

	/**
	 * @param weight the weight to set
	 */
	public void setWeight(int weight) {
		this.weight = weight;
	}

	/**
	 * @return the from
	 */
	public Vertex getFrom() {
		return from;
	}

	/**
	 * @param from the from to set
	 */
	public void setFrom(Vertex from) {
		this.from = from;
	}

	/**
	 * @return the to
	 */
	public Vertex getTo() {
		return to;
	}

	/**
	 * @param to the to to set
	 */
	public void setTo(Vertex to) {
		this.to = to;
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

	

	public Edge(int weight, Vertex from, Vertex to, boolean visited) {
		super();
		this.weight = weight;
		this.from = from;
		this.to = to;
		this.visited = visited;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Edge [weight=" + weight + ", from=" + from + ", to=" + to
				+ ", visited=" + visited + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((from == null) ? 0 : from.hashCode());
		result = prime * result + ((to == null) ? 0 : to.hashCode());
		result = prime * result + weight;
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
		if (!(obj instanceof Edge)) {
			return false;
		}
		Edge other = (Edge) obj;
		if (from == null) {
			if (other.from != null) {
				return false;
			}
		} else if (!from.equals(other.from)) {
			return false;
		}
		if (to == null) {
			if (other.to != null) {
				return false;
			}
		} else if (!to.equals(other.to)) {
			return false;
		}
		if (weight != other.weight) {
			return false;
		}
		return true;
	}

	/*private Graph getOuterType() {
		return Graph.this;
	}	*/
	
	
}
