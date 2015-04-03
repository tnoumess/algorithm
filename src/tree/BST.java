/**
 * 
 */
package tree;

/**
 * @author Thierry Edson Noumessi
 * @param <E>
 * @param <E>
 *
 * @date Apr 2, 2015
 * @11:57:37 PM
 * @BST.java
 */
public class BST<E extends Comparable<E>> {
	
	public Node<E> root;
	
	private int size;
	
	
	
	/**
	 * 
	 * @param root
	 */

	public BST() {
		//super();
		this.size=0;
		this.root=null;
		
	}

	public void insert(E val){
		
		root=insert(val,root);
	}



private Node<E> insert(E val, Node<E> n){
	System.out.print("");
	if(n==null){
		
		 n=new Node<E>(val);
		 size++;
	}
	else{
	if(compare(val,n.getValue())<0){n.left=insert(val,n.left);}
	if(compare(val,n.getValue())>0){n.right= insert(val,n.right);}
	}
	return n;
	
}

public void delete(int val){}


/**
 * 
 * Pre_order search

 * @param val
 * @return
 */
public boolean find(E val){
	
	if(root==null){
		System.out.println(val+" not found in the tree");
		return false;
		}
	
	return find(val,root);
	
}

private boolean find(E val,Node<E> n){
	
	if ((n==null)||((n.getValue()!=val)&&((n.left==null)&&(n.right==null))))  return false;
	
	if (n.getValue()==val) return true;
    if (compare(val,n.getValue())<0) return find(val,n.left);
    else return find(val,n.right);
    
	
	
}


/**
 * 
 * @return the height of the tree
 */
public int height(){
	
	return height(root);
}
private int height(Node<E> n){
	if(n==null) return -1;
	
	int left_h=height(n.left);
	int right_h=height(n.right);
	return left_h > right_h ? left_h + 1 : right_h + 1;
}
/**
 * 
 * @param key
 * @return  
 * 
 * returns -1 if the key is not in the tree OR 
 * returns the depth of the Node containing the corresponding tree.
 */
public int depth(E key){
	
	int c=-1;
	if(key==root.getValue()) return 0;
	return finddepth(key,root,c);
}

/**
 * @param key
 * @param root2
 * @param c
 * @return
 */
private int finddepth(E key, Node<E> n, int c) {
	// TODO Auto-generated method stub
if ((n==null)||((n.getValue()!=key)&&((n.left==null)&&(n.right==null))))  return -1;
	
	if (n.getValue()==key) return 1+c;
    if (compare(key,n.getValue())<0){ c++; return finddepth(key,n.left,c);}
    else {c++; return finddepth(key,n.right,c);}
    
    
}

public int depth(){
	return 0;
}
/**
 * Size of the tree
 * @return
 */
public int numelemt(){
	return size;
}

/**
 * 
 * Print InOrder
 */
public void printInorder(){
	if(numelemt()==0) System.out.println("The tree is empty");
	inorder(root);
}

/**
 * Print PreOrder
 * 
 */
public void printPreorder(){
	if(numelemt()==0) System.out.println("The tree is empty");
	preorder(root);
}

/**
 * Print PostOrder
 * 
 */
public void printPostorder(){
	if(numelemt()==0) System.out.println("The tree is empty");
	postorder(root);
}

/**
 * PreOrder traversal
 * @param n
 * 
 */
private void preorder(Node<E> n){
	
	if(n==null){}
	else{
		System.out.println(n.getValue());
		preorder(n.left);
		preorder(n.right);
	}
}

/**
 * PostOrder traversal 
 * @param n
 */
private void postorder(Node<E> n){
	if(n==null){}
	else{
		postorder(n.left);
		postorder(n.right);
		System.out.println(n.getValue());
	}
}

/**
 * InOrder traversal
 * @param n
 */
private void inorder(Node<E> n){
	if(n==null){}
	else{
		inorder(n.left);
		System.out.println(n.getValue());
		inorder(n.right);
	}
}


/* (non-Javadoc)
 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
 */

public int compare(E n1, E n2) {
	// TODO Auto-generated method stub	
    return n1.compareTo(n2);
}

	/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Override
public String toString() {
	return "BST [root=" + root + ", size=" + size + "]";
}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BST<String> b=new BST<String>();
		/*b.insert(10);
		b.insert(15);
		b.insert(5);
		
		b.insert(4);
		b.insert(25);
		b.insert(13);
		b.insert(3);*/
		b.insert("aa");
		b.insert("za");
		b.insert("h");
		
		b.insert("9hgg");
		b.insert("0gf");
		b.insert("yz");
		System.out.println(b);
		b.printInorder();
		System.out.println(b.depth("0yz"));
	}


	
}
