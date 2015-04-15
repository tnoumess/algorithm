/**
 * 
 */
package trie;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Thierry Edson Noumessi
 *
 * @date Apr 13, 2015
 * @11:41:50 AM
 * @RWT.java
 */
public class RWT<Value> {

	
	private static final int R=256;
	private Node root=new Node();
	
		
	private static class Node{
		
		private Object value;
		private Node[] next =new Node[R];		
		
	}
	
	/**
	 * return the set containing all the keys.
	 * Inorder traversal
	 * @return An iterator
	 */
	public Iterable<String> keys()
	{
	 Queue<String> queue = new LinkedList<String>();
	 collect(root, "", queue);
	 return queue;
	}
	
	private void collect(Node x, String prefix, Queue<String> q)
	{
	 if (x == null) return;
	 if (x.value != null) q.add(prefix);
	 for (char c = 0; c < R; c++)
	 collect(x.next[c], prefix + c, q);
	}
	
	/**
	 * return the set containing all the key with the given prefix
	 * @param prefix
	 * @return
	 */
	public Iterable<String> keysWithPrefix(String prefix)
	{
	 Queue<String> queue = new LinkedList<String>();
	 /**
	  * put the prefix into the node x.
	  */
	 Node x = get(root, prefix, 0);
	 collect(x, prefix, queue);
	 return queue;
	}
	/**
	 * Longest key that is a prefix of query
	 * @param query
	 * @return
	 */
	 public String longestPrefixOf(String query)
	 {
	 int length = search(root, query, 0, 0);
	 return query.substring(0, length);
	 }
	
	 private int search(Node x, String query, int d, int length)
	 {
	   if (x == null) return length;
	 	 if (x.value != null) length = d;
	 		if (d == query.length()) return length;
	      char c = query.charAt(d);
	   
	      return search(x.next[c], query, d+1, length);
	 }
	 
	/**
	 * 
	 * @param key
	 * @param val
	 */
	public void put(String key,Value val){
		
	 root=put(root,key,val,0);
		
	}
	
	/**
	 * 
	 * @param x
	 * @param key
	 * @param val
	 * @param d
	 * @return
	 */
	private Node put(Node x, String key,Value val, int d){
		
		if(x==null) x=new Node();
		if(d==key.length()) {x.value=val;return x;}
		char c=key.charAt(d);
		x.next[c]=put(x.next[c],key ,val,d+1);
		return x;		
		
	}
	/**
	 * 
	 * @param key
	 * @return
	 */
	public boolean contains(String key){ return get(key)!=null;}
	
	/**
	 * Retrieve the value of a given key string
	 * 
	 * @param key
	 * @return
	 */
	
	@SuppressWarnings("unchecked")
	public Value get(String key){
		
		Node x=get(root,key,0);
		if(x==null) return null;
		return(Value) x.value;
	}
	/**
	 * Insert the key in the given Node
	 * 
	 * @param x
	 * @param key
	 * @param d
	 * @return
	 */
	private Node get(Node x, String key,int d){
		
		if(x==null) return null;
		if (d==key.length()) return x;
		char c=key.charAt(d);
				
		return get(x.next[c],key,d+1);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		RWT<Integer> r=new RWT<Integer>();
		
		r.put("shells", 3);
		r.put("by", 4);
		r.put("the", 5);
		r.put("thecar", 2);
		r.put("temamic", 6);
		
		System.out.println(r.contains("by"));
		System.out.println(r.keys().toString());
		System.out.println(r.longestPrefixOf("thecapobnh"));
	}

}
