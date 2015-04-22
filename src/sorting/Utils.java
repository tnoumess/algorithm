/**
 * 
 */
package sorting;

import heap.PriorityQueue;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Thierry Edson Noumessi
 *
 * @date Apr 1, 2015
 * @8:14:08 PM
 * @Utils.java
 */

@SuppressWarnings({"rawtypes","unchecked"})
public class Utils<E extends Comparable<E>> {
	
	public static void swap(int[] a,int i,int j){
		
		if(i!=j){
		int temp=a[i];
		a[i]=a[j];
		a[j]=temp;
		}
		//System.out.println("swapped");		
	}
	/**
	 * Generic Swap
	 * @param a Destination Array 
	 * @param i Index of element #1 to be swapped 
	 * @param j Index of element #2 to be swapped
	 */
public static  void swap(Comparable[] a,int i,int j){
		
		if(i!=j){
		Comparable temp=a[i];
		a[i]=a[j];
		a[j]=temp;
		}
		//System.out.println("swapped");		
	}
	public static Comparable[] merge(Comparable[] dest,Comparable[] left,Comparable[] right){
		
		/*
		 * Optimization
		 * If by chance 'dest' is already sorted?
		 */
		if(left[left.length-1].compareTo(right[0])<=0) return dest;
		
		int dind = 0;
		int lind = 0;
		int rind = 0;
		System.out.println("in merge");
		while ( lind < left.length && rind < right.length ){
			if ( left[ lind ].compareTo(right[ rind ])<=0 ){
			dest[ dind++ ] = left[ lind++ ];
			} else {
				
				dest[ dind++ ] = right[ rind++ ];
			}
			}
		System.out.println("in merge");
			// Copy rest of whichever array remains
			while ( lind < left.length )
			dest[ dind++ ] = left[ lind++ ];
			while ( rind < right.length )
			dest[ dind++ ] = right[ rind++ ];			
			System.out.println("in merge");
			return dest;
	}
	
	public static void Iterator(Map<String,String> m,Hashtable<String, String> h,Set<String> set){
		
		for(Map.Entry<String,String> entry: m.entrySet()){						
		entry.getKey();
		entry.getValue();					
		}
		
		for(String s: m.keySet()){			
			System.out.println(s);
		}
		
        for(String s: m.values()){			
			System.out.println(s);
		}		
           
        for(Map.Entry hashtableentry: h.entrySet()){
        	hashtableentry.getValue();
        	hashtableentry.getKey();        	
        }
        
        for(String s:set){
        	System.out.println(s);
        	
        }
                
	}
	
	
	public static void Collection(){
		
		
		//Does not maintain any order
		HashSet<String> VisitList=new HashSet<String>();
		VisitList.add("me");
		VisitList.contains("x");
		VisitList.isEmpty();
		VisitList.remove("");
		VisitList.toArray();
		
		// maintain order of insertion
				Set<String> lhs=new LinkedHashSet<>();
				lhs.add("edson");
				lhs.iterator();
		
		//elements sorted in natural order. not thread safe
		TreeMap<String,Integer> tm= new TreeMap<String, Integer>();		
		tm.put("houston", 200);
		tm.containsKey("houston");
		tm.containsValue(200);
		tm.get("houston");
		tm.remove("houston");
		
		
		//thread safe. no null values
		Hashtable<String,String> ht=new Hashtable<String, String>();		
		ht.put("houston","usa");
		ht.elements();// Enumeration
		
		
		Stack<String> s=new Stack<String>();
		s.capacity();// How much element it can hold.
		s.search("gu");
		s.peek();
		s.pop();
		s.push("me");
		
		Queue<String> q=new LinkedList<String>();
		q.add("aaa");
		q.add("bbb");
		q.toString();// aaa bbb
		q.peek();// aaa
		q.remove(); //remove head(aaa)
		q.poll();// return head and remove it from the list (peek+remove)
		
		//immutable
		String string="aaa";
		string.charAt(0);
		string.concat("you");
		string.contains("a");//bool
		string.endsWith("gf");//bool
		string.indexOf("u");
		string.indexOf("h", 5); // from index 5
		string.substring(5, 7);// from 5 to 7
		string.toUpperCase();
		string.trim();
		
		//mutable and not thread safe
		StringBuilder sb=new StringBuilder("edson");
		sb.append("k");
		sb.deleteCharAt(5);
		sb.delete(5, 6);	
		sb.charAt(0);
		sb.insert(0, "my nam is");
		
		//mutable and thread safe
		StringBuffer sbf=new StringBuffer("edson");
		sbf.append("k");
		sbf.deleteCharAt(5);
		sbf.delete(5, 6);	
		sbf.charAt(0);
		sbf.reverse();		
		
		//random
		double r=Math.random();
		//max=55 min=1
		int x=(new Random()).nextInt(55)+1;
		
		//String man
		String k="noumessit hierriedson";
		char[] cc=k.toCharArray();
		System.out.println(new String(cc,5,10));//ssit hierr
		
		//convert int into its corresponding ASCII char
		System.out.println((char)120);
		//return the decimal corresponding to the given ASCII 
		System.out.println((int)'d');
	}
	/**
	 * Add to numbers by using assertion
	 * @param a
	 * @param b
	 * @return
	 */
	public static int sum(int a, int b) {
	    assert (Integer.MAX_VALUE - a >= b) : "Value of " + a + " + " + b + " is too large to add.";
	  final int result = a + b;
	    assert (result - a == b) : "Sum of " + a + " + " + b + " returned wrong sum " + result;
	  return result;
	}
	
	private static final Object lock=new Object();
	private static final Lock lock2=new ReentrantLock();
	public  void concurrency1(){
		synchronized (lock) {
			
		}	
	}
	public void conccurency2(){
		
		/*
		 * It returns true if the locking succeeds, 
		 * false if Lock is already locked. This method never blocks. 
		 */
		lock2.tryLock();
		/*
		 * processing 
		 */
		lock2.unlock();
	}
    public void conccurency3(){
		
		/*
		 * If the Lock instance is already locked,
		 * the thread calling lock() is blocked until the Lock is unlocked. 
		 */
		lock2.lock();
		/*
		 * processing 
		 */
		lock2.unlock();
	}
	
}
