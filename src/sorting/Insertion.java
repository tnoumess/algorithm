/**
 * 
 */
package sorting;

/**
 * @author Thierry Edson Noumessi
 *
 * @date Apr 1, 2015
 * @9:12:03 PM
 * @Insertion.java
 * 
 *  Insertion sort
 */
public class Insertion {

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
			
			for(int i=1; i<a.length;i++){
			int temp=a[i],j;	
				
				for( j=i;j>0&&temp<a[j-1];j--){
					a[j]=a[j-1];
				}
				a[j]=temp;	
			}
			return a;
		}
		
	}
	
	public static void print(int[] a){
			
		if(a.length==1)
			System.out.println(a[0]);
		for(int i=0; i<a.length;i++)
		System.out.println(a[i]);
	}
	

}