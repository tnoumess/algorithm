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
@SuppressWarnings({"rawtypes","unchecked"})
public class Insertion<E extends Comparable<E>> {

Comparable[] a;


public static Comparable[] Sort(Comparable[] a){
	
	if(a.length<2)
		return a;
	else{
		
		for(int i=1; i<a.length;i++){
		Comparable temp=a[i];
		int j;	
			
			for( j=i;j>0&&temp.compareTo(a[j-1])<0;j--){
				a[j]=a[j-1];
			}
			a[j]=temp;	
		}
		return a;
	}
	
	
}
	
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
	
	/**
	 * Generic Sort
	 * @param a is an array of integer
	 * @return an   ordered copy of array a
	 * Time Complexity O(n^2)
	 * Space Complexity O(1)
	 * 
	 */
	/*public static <E extends Comparable<E>> E[] Sort(E[] a){
		/**
		 * Precondition: a is and unordered array of integer
		 * Postcondition: c is an ordered copy of a
		 */
		//int[] c=(int[])a.clone();
	/*	if(a.length<2)
			return a;
		
		else{
			
			for(int i=1; i<a.length;i++){
			E temp=a[i];
			int j;
				
				for( j=i;j>0&&temp.compareTo(a[j-1])<0;j--){
					a[j]=a[j-1];
				}
				a[j]=temp;	
			}
			return a;
		}
		
	}*/
	/**
	 * Raw print
	 * @param a
	 */
	public static void print(Comparable[] a){
			
		if(a.length==1)
			System.out.println(a[0]);
		for(int i=0; i<a.length;i++)
		System.out.println(a[i]);
	}
	
	/**
	 * Generic Print
	 * @param a
	 */
	/*public static <E> void print(E[] a){
		
		if(a.length==1)
			System.out.println(a[0]);
		for(int i=0; i<a.length;i++)
		System.out.println(a[i]+",");
	}
		*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Comparable[] a={15,4,5,3,8,857,19,6,7,84,20,15,87,945,214,57,94,34,8,69,41,52,84,34,567,845,132,87,5,23,468,125,156,15,15,488,754,2654,58,55,744,112,6,6,88,77,55,224,7954,12457,5774,55,7843145,7884,24,785,251324,785479,54214,75366,21,45,29,70,30,145,752,478,5,5,2,10,1,4,85,97,12,02145,787};

		
long startTime = System.nanoTime();
print(Sort(a));
long endTime = System.nanoTime();
System.out.println("");
System.out.println(endTime-startTime);





	}

}