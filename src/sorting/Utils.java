/**
 * 
 */
package sorting;

/**
 * @author Thierry Edson Noumessi
 *
 * @date Apr 1, 2015
 * @8:14:08 PM
 * @Utils.java
 */
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
public static <E> void swap(E[] a,int i,int j){
		
		if(i!=j){
		E temp=a[i];
		a[i]=a[j];
		a[j]=temp;
		}
		//System.out.println("swapped");		
	}
	public static int[] merge(int[] dest,int[] left,int[] right){
		int dind = 0;
		int lind = 0;
		int rind = 0;
		System.out.println("in merge");
		while ( lind < left.length && rind < right.length ){
			if ( left[ lind ] <= right[ rind ] ){
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
	
	public static <E extends Comparable<E>> E[] merge(E[] dest,E[] left,E[] right){
		int dind = 0;
		int lind = 0;
		int rind = 0;
		System.out.println("in merge");
		while ( lind < left.length && rind < right.length ){
			if ( (left[lind]).compareTo(right[ rind ])<=0 ){
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

}
