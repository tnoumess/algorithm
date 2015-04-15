/**
 *
 * You have an unordered array X of n integers. 
 * Find the array M containing n elements where 
 * Mi is the product of all integers in X except for Xi.
 * You may not use division. You can use extra memory. 
 * (Hint: There are solutions faster than O(n2).)
 */
package exercices;

/**
 * @author Thierry Edson Noumessi
 *
 * @date Apr 7, 2015
 * @10:23:15 PM
 * @Multiplication.java
 */
public class Multiplication {
	
	
	
	private static int productLeft(int[] x,int i,int j){
		
		if(i<0)
			return 1;
	
		return x[i]*productLeft(x, i-1, j);
	}
    private static int productRight(int[] x,int i,int j){
		
		if(i>=j)
			return 1;
		
		return x[i]*productRight(x, i+1, j);
	}

   private static int product(int[] x,int[] y,int i,int j){
	
	   if(i==j){
		   return productLeft(x, i-2, j);
	   }
	
	return x[i]*productLeft(x, i-2, j)*productRight(x, i+1, j);
    
   }
   public static int[] product(int[] x){
	   
	   int[] M=new int[x.length];
	   for (int i=0;i<x.length;i++){
		   
		   M[i]=product(x, M, i+1, x.length);
	   }
	   return M;
   }
   
   /**
	 * Raw print
	 * @param a
	 */
	public static void print(int[] a){
			
		if(a.length==1)
			System.out.println(a[0]);
		for(int i=0; i<a.length;i++)
		System.out.print(","+a[i]);
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] a={1,2,3,1,2,3,1};
		System.out.print("[");
		print(product(a));
		System.out.print("]");
		
	}

}
