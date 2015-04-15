/**
 * 
 */
package sorting;

/**
 * @author Thierry Edson Noumessi
 *
 * @date Apr 14, 2015
 * @9:16:28 PM
 * @Quick.java
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
public class Quick {
	
	/**
	 * Partition the array into two parts and return  j
	 * such as A[low],...,A[j-2],A[j-1]<=   A[j]   <=A[j+1],A[j+2],..A[high]
	 * @param A
	 * @param low
	 * @param high
	 * @return
	 */
	private static int partition(Comparable[] A,int low,int high){
		
		int i=low;
		int j=high+1;
		
		while(true){
			
			while(A[++i].compareTo(A[low])<0){
				if(i==high) break;
			}
			
			while(A[low].compareTo(A[--j])<0){
				if(i==low) break;
			}
			
			if(i>=j)break;
			Utils.swap(A, i, j);
			
		}
	Utils.swap(A, low, j);
	return j;
		
	}
	/**
	 * Quicksort routine
	 * @param a
	 * @return
	 */
	public static Comparable[] sort(Comparable[] a)
	 {
		 if(a.length<20)
				return Insertion.Sort(a);
	  //  Do shuffle(a) is recommended to avoid Time complexity O(n^2);
	    sort(a, 0, a.length - 1);
	    
	    return a;
	    
	 }
	/**
	 * 
	 * @param a
	 * @param lo
	 * @param hi
	 */
	private static void sort(Comparable[] A, int lo, int hi)
	 {
		
	   if (hi <= lo) return;
	   int j = partition(A, lo, hi);
	   sort(A, lo, j-1);
	   sort(A, j+1, hi);
	 
	 }
   /**
    * Print routine
    * @param a
    */
	public static void print(Comparable[] a){
		
		if(a.length==1)
			System.out.println(a[0]);
		for(int i=0; i<a.length;i++)
		System.out.println(a[i]);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Comparable[] a={15,4,5,3,8,857,19,6,7,84,20,15,87,945,214,57,94,34,8,69,41,52,84,34,567,845,132,87,5,23,468,125,156,15,15,488,754,2654,58,55,744,112,6,6,88,77,55,224,7954,12457,5774,55,7843145,7884,24,785,251324,785479,54214,75366,21,45,29,70,30,145,752,478,5,5,2,10,1,4,85,97,12,02145,787};

		
		long startTime = System.nanoTime();
		print(sort(a));
		long endTime = System.nanoTime();
		System.out.println("");
		System.out.println(endTime-startTime);


	}

}
