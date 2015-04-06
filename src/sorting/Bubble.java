/**
 * 
 */
package sorting;

/**
 * @author Thierry Edson Noumessi
 *
 * @date Apr 1, 2015
 * @8:13:30 PM
 * @Bubble.java
 * 
 *  bubble sort
 */
public class Bubble<E extends Comparable<E>> {
	
	int[] a;
	
	/**
	 * 
	 * @param a is an array of integer
	 * @return an   ordered copy of array a
	 * 
	 * Time Complexity O(n^2)
	 * Space Complexity O(1)
	 */
	public static int[] Sort(int[] a){
		/**
		 * Precondition: a is and unordered array of integer
		 * Postcondition: c is an ordered copy of a
		 */
		
		boolean swapped=false;
		if(a.length<2)
			return a;
		
		else{
			
			for(int i=a.length-1; i>0;i--){
				
				
				for(int j=0;j<i;j++){
					if(a[j] > a[j+1]){
						Utils.swap(a, j, j+1);	
						swapped=true;
					}
					
				}
				if(swapped==false)
					return a;
			}
			return a;
		}
		
	}
	
	
	public static <E extends Comparable<E>> E[] Sort(E[] a){
		/**
		 * Precondition: a is and unordered array of integer
		 * Postcondition: c is an ordered copy of a
		 */
		
		boolean swapped=false;
		if(a.length<2)
			return a;
		
		else{
			
			for(int i=a.length-1; i>0;i--){
				
				
				for(int j=0;j<i;j++){
					if(((Comparable<E>) a[j]).compareTo(a[j+1])>0){
						Utils.swap(a, j, j+1);	
						swapped=true;
					}
					
				}
				if(swapped==false)
					return a;
			}
			return a;
		}
		
	}
	
	/**
	 * Raw print
	 * @param a
	 */
	public static void print(int[] a){
			
		if(a.length==1)
			System.out.println(a[0]);
		for(int i=0; i<a.length;i++)
		System.out.println(a[i]+",");
	}
	/**
	 * Generic Print
	 * @param a
	 */
	public static <E> void print(E[] a){
		
		if(a.length==1)
			System.out.println(a[0]);
		for(int i=0; i<a.length;i++)
		System.out.println(a[i]+",");
	}
		

}
