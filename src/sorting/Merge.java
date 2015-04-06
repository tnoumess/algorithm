/**
 * 
 */
package sorting;

/**
 * @author Thierry Edson Noumessi
 *
 * @date Apr 1, 2015
 * @9:28:06 PM
 * @Merge.java
 * 
 *  Merge sort
 */
public class Merge {

	/**
	 * We could not create a generic merge function 
	 * due to the impossibility of creating a 
	 * Generic array(for the merge) in Java. 
	 * 
	 * @param args
	 */
	
int[] a;
	
	/**
	 * 
	 * @param a is an array of integer
	 * @return an   ordered copy of array a
	 * Time Complexity O(n.log(n))
	 * Space Complexity O(n)
	 * 
	 */
	public static int[] Sort(int[] a){
		/**
		 * Precondition: a is and unordered array of integer
		 * Postcondition: c is an ordered copy of a 
		 * */
	
	   if(a.length<20)
			return Insertion.Sort(a);
		
		
		int[] left=new int[a.length/2];
		int[] right=new int[a.length-(a.length/2)];
				
		System.arraycopy( a, 0, left, 0, a.length/2 );
		System.arraycopy( a, a.length/2, right, 0, a.length-(a.length/2));			
		Sort(left);
		Sort(right);
		return Utils.merge(a, left, right);
					
	}
	
	/**
	 * 
	 * @param a is an array of integer
	 * @return an   ordered copy of array a
	 * Time Complexity O(n.log(n))
	 * Space Complexity O(n)
	 * 
	 */
	
	public static void print(int[] a){		
		if(a.length==1)
			System.out.println(a[0]);
		for(int i=0; i<a.length;i++)
		System.out.print(a[i]+",");
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
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] a={15,4,5,3,8,857,19,6,7,84,20,15,87,945,214,57,94,34,8,69,41,52,84,34,567,845,132,87,5,23,468,125,156,15,15,488,754,2654,58,55,744,112,6,6,88,77,55,224,7954,12457,5774,55,7843145,7884,24,785,251324,785479,54214,75366,21,45,29,70,30,145,752,478,5,5,2,10,1,4,85,97,12,02145,787};

		
long startTime = System.nanoTime();
print(Sort(a));
long endTime = System.nanoTime();
System.out.println("");
System.out.println(endTime-startTime);

	}

}
