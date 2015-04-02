/**
 * 
 */
package sorting;

import java.util.Arrays;

/**
 * @author Thierry Edson Noumessi
 *
 * @date Apr 1, 2015
 * @8:58:16 PM
 * @Selection.java
 * 
 *  Insertion sort
 */
@SuppressWarnings("unused")
public class Selection {

int[] a;
	
	/**
	 * 
	 * @param a is an array of integer
	 * @return an   ordered copy of array a
	 * Time Complexity O(n^2)
	 * Space Complexity O(1)
	 * 
	 */
	public static int[] Sort(int[] a){
		/**
		 * Precondition: a is and unordered array of integer
		 * Postcondition: c is an ordered copy of a
		 */
		//int[] c=(int[])a.clone();
		if(a.length<2)
			return a;
		
		else{
			
			for(int i=a.length-1; i>0;i--){
			int temp=0;	
				
				for(int j=1;j<=i;j++){
					if(a[j] > a[temp]){
						temp=j;					
					}
				}
				Utils.swap(a, i, temp);	
			}
			return a;
		}
		
	}
	
	public static void print(int[] a){
			
		if(a.length==1)
			System.out.println(a[0]);
		else{
		for(int i=0; i<a.length;i++)
		System.out.print(a[i]+",");
		}
	}	

	

}