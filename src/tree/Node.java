/**
 * 
 */
package tree;

import java.util.Comparator;

/**
 * @author Thierry Edson Noumessi
 *
 * @date Apr 3, 2015
 * @12:01:42 AM
 * @Node.java
 */

//E is element of the collection and must also be comparable
public class Node<E extends Comparable<E>> implements Comparator<E>  {
	
	private E value;
	Node<E> left;
	Node<E> right;
	
	public Node(E value) {
		super();
		this.value = value;
		
	}
	

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Node [value=" + value + ", left=" + left + ", right=" + right
				+ "]";
	}


	public Node() {
		super();
		// TODO Auto-generated constructor stub
	}


	/**
	 * @return the value
	 */
	public E getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(E value) {
		this.value = value;
	}

	/**
	 * @return the left
	 */
	public Node<E> getLeft() {
		return left;
	}

	/**
	 * @param left the left to set
	 */
	public void setLeft(Node<E> left) {
		this.left = left;
	}

	/**
	 * @return the right
	 */
	public Node<E> getRight() {
		return right;
	}

	/**
	 * @param right the right to set
	 */
	public void setRight(Node<E> right) {
		this.right = right;
	}


	/* (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(E n1, E n2) {
		// TODO Auto-generated method stub
	
	    return n1.compareTo(n2);
	}
	
	

}
