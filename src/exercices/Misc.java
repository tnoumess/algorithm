/**
 * 
 */
package exercices;

import java.util.BitSet;
import java.util.Hashtable;

/**
 * @author Thierry Edson Noumessi
 *
 * @date Apr 11, 2015
 * @12:52:47 PM
 * @Misc.java
 */
public  class Misc {
	
	public static int match (String target, String source){
		int [][] f = new int[target.length() + 1][source.length() + 1] ;
		for (int i = 0 ; i <= source.length() ; ++i) {
			f[0][i] = 1;
		}
		f[0][0] = 1;
		for (int i = 1 ; i <= target.length() ; ++i) {
		 for (int j = 1 ; j <= source.length() ; ++j) {
			 if (target.charAt(i - 1) == source.charAt(j - 1)) {
				 f[i][j] = f[i - 1][j - 1] + f[i][j - 1] ;  
			 } else{
				 f[i][j] = f[i][j - 1] ;
			 }
		 }
		}
		return f[target.length()][source.length()] ;
}
	/**
	 * write an algorithm to find sum of numbers which are smaller
	 *  than N and divisible by 3 or 5 
     * Example: 
     * N = 9 => 3 + 5 + 6 = 14 
     * N = 10 => 3 + 5 + 6 + 9 = 23
     * @param N
	 * @return
	 */
	public static int sum(int N){
		
		if (N>=3){
			int sum=0;
			for (int i=N-1;i>=3;i--){
				
				if (i%5==0||i%3==0)
					sum=sum+i;
			}
			return sum;
		}
		return 0;
	}
	
	public static int SumOfNumber(int N){
        N--;
	int divisibleBy3 = N/3;
	divisibleBy3 = (divisibleBy3 * (divisibleBy3 + 1) /2)*3;

	int divisibleBy5 = N/5;
	divisibleBy5 = (divisibleBy5 * (divisibleBy5 + 1) /2)*5;

	int divisibleBy15 = N/15;
	divisibleBy15 = (divisibleBy15 * (divisibleBy15 + 1) /2)*15;
	
	return divisibleBy3 + divisibleBy5 - divisibleBy15;
}

	
	/**
	 * Write a function that prints all ASCII characters. 
	 * You are not allowed to use for/while loop.
	 */
	public static void printAscii(){
		printAscii(0);
	}
	
	private static void printAscii(int x){
		char y = (char)x;
		System.out.println(y);
		System.out.println(x);
		x += 1;
		if(x< 129){
			
			printAscii(x);
		}
	}
	
	/**
	 * Given 1 byte. Write a function that checks that it have exactly 3 bits which equal to 1.
	 * @param n
	 * @return
	 */
public static  boolean validateByte(int n) {
    int  rst = 0 ;
    while (n != 0) {
   	 n = n & (n - 1);
   	 rst++;
    }
    return rst == 3 ;
}

	/**
	 * You are given a positive integer number N. Return the minimum number K,
	 *  such that N can be represented as K integer squares. Examples: 
     * 9 --> 1 (9 = 3^2) 
     * 8 --> 2 (8 = 4^2 + 4^2) 
     * 15 --> 4 (15 = 3^2 + 2^2 + 1^2 + 1^2) 
     * First reach a solution without any assumptions, 
     * then you can improve it using this mathematical lemma:
     * For any positive integer N, there is at least one representation of N as 4 or less squares.


	 * @param N
	 * @return
	 */
	public static int NumbSq(int N){
		
		if(Math.sqrt(N)%1==0) return 1;
		
		int k=0,sum=0,sq=(int) Math.sqrt(N);
		
		
		while(sum!=N){
		
		sum=sum + sq*sq;
		k++;
		if(sq==1) return k+N-sum;		
		if(sum==N) return k;
		
		sq--;		
		int temp=sum+sq*sq;
		
		while(temp>N){
			
			temp=temp-sq*sq;
			sq--;
			temp=sum+sq*sq;
		  }
			
		}
		return k;
	}
	
	/**
	 * Assume we only take the least significant digit of each value in fibonacci sequence,
	 *  and form the sequence of digits into pairs. In those pairs, the first value of one 
	 *  pair is the same as second value of its predecessor. 
     *  As we know the fibonacci sequence is 1, 1, 2, 3, 5, 8, 13, 21... 
     *  so the pair sequence is: 
     *  [1, 1], [1, 2], [2, 3], [3, 5], [5, 8], [8, 3], [3, 1] ... 
     *
     *  Write a function to output the first n pairs of this sequence. 
     * @param N
	 */
	public static void CustumFibo(int N){
		
		int prev=1,next=1;
		for(int i=1;i<=N;i++){
			
			print(prev, next);
			int temp=next;
			next=next+prev;
			prev=temp;
		}
		
	}
	
	private static void print(int i,int k){
		
		System.out.print("["+i+","+k+"]");
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//System.out.println(match("dog","dogdegong"));
		//System.out.println(SumOfNumber(1999));
		//System.out.println(sum(1999));
		//Hashtable a=new Hashtable();
		//a.put(1, false);
		//BitSet b=new BitSet();
		//System.out.println(Runtime.getRuntime().totalMemory());
	//	printAscii();
		double x=33;
		char c='/';
		System.out.println((char)x);
		System.out.println(2.5%1);
		System.out.println(Math.abs(5));
		System.out.println(NumbSq(12));
	CustumFibo(00);	
	}

}
