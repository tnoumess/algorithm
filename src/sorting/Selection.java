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
public class Selection<E extends Comparable<E>> {

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
	
	/**
	 * Generic Sort
	 * @param a is an array of integer
	 * @return an   ordered copy of array a
	 * Time Complexity O(n^2)
	 * Space Complexity O(1)
	 * 
	 */
	public static <E extends Comparable<E>> E[] Sort(E[] a){
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
					if(a[j].compareTo(a[temp])>0){
						temp=j;					
					}
				}
				Utils.swap(a, i, temp);	
			}
			return a;
		}
		
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
	/**
	 * Raw print
	 * @param a
	 */
	public static void print(int[] a){
			
		if(a.length==1)
			System.out.println(a[0]);
		else{
		for(int i=0; i<a.length;i++)
		System.out.print(a[i]+",");
		}
	}	

	public static void main(String[] args) {
		int[] a={15,4,5,3,8,857,19,6,7,84,20,15,87,945,214,57,94,34,8,69,41,52,84,34,567,845,132,87,5,23,468,125,156,15,15,488,754,2654,58,55,744,112,6,6,88,77,55,224,7954,12457,5774,55,7843145,7884,24,785,251324,785479,54214,75366,21,45,29,70,30,145,752,478,5,5,2,10,1,4,85,97,12,02145,787};
       String[] b={"noumessi","thierry","edson"};
		Selection<Integer> s= new Selection<Integer>();
       Selection.Sort(b);
       Selection.print(b);
	}

}