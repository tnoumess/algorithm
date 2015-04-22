/**
 * 
 */
package exercices;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import sorting.Utils;

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
	
	public static void stringPermut(String[] s){
	
		/*for (int i=0;i<s[0].length();i++){
			
			
			for (int j=0;j<s[1].length();j++){
				
				for (int k=0;k<s[2].length();k++){
					
					System.out.print(s[0].charAt(i));
					System.out.print(s[1].charAt(j));
					System.out.println(s[2].charAt(k));
								
					
				}
				
			}
			
		}*/
		int[] iC=new int[5];
		assert iC.length==5: "d is null";
		//permute(s,iC,0);
		
	}
	
	
	public static void permuteStrings() {
		List<String> inlist = Arrays.asList("quick","fox","red","pop");
		List<String> result = new ArrayList<>();
		for(String each : inlist) {
			char[] carray = each.toCharArray();
			List<String> temp = new ArrayList<>();
			for(char c : carray) {
				if(result.size() > 0) {
					for(String eachRes : result) {
						StringBuilder sb = new StringBuilder(eachRes);
						sb.append(c);
						temp.add(sb.toString());
					}					
				} else {
					temp.add(String.valueOf(c));

				}
			}
			result = temp;
		}
		System.out.println(result);
	}
/**
 * EM Write an efficient function that deletes characters from an ASCII
 * string. Use the prototype
 * string removeChars( string str, string remove );
 * where any character existing in remove must be deleted from str. For example,
 * given a str of "Battle of the Vowels: Hawaii vs. Grozny" and a remove of
 * "aeiou", the function should transform str to “Bttl f th Vwls: Hw vs. Grzny”.
 * Justify any design decisions you make, and discuss the efficiency of your solution.
 * @param str
 * @param remove
 * @return
 */
	
	public static String removeChars( String str, String remove ){
		 char[] s = str.toCharArray();
		 char[] r = remove.toCharArray();
		 int src, dst = 0;
		 // flags automatically initialized to false, size of 128 assumes ASCII
		 boolean[] flags = new boolean[128];
		 // Set flags for characters to be removed
		 for( src = 0; src < r.length; ++src ){
		 flags[r[src]] = true;
		 }
		 // Now loop through all the characters,
		 // copying only if they aren’t flagged
		 for( src = 0; src < s.length; ++src ){
		 if( !flags[ s[src] ] ){
		 s[dst++] = s[src];
		 }
		 }
		 return new String( s, 0, dst );
		}
	
	/*
	* Write a function that reverses the order of the words in a string. For
    * example, your function should transform the string 
    * "Do or do not, there is no try." to "try. no is there not, do or Do". 
    * Assume that all words are space delimited
    * and treat punctuation the same as letters
    */
	
	public static void reverse(String s){
		
		StringBuffer sb1=new StringBuffer();
		int k=0;
		StringBuffer sb2=new StringBuffer();
		StringBuffer sb3=new StringBuffer();
		
		
		for(int i=s.length()-1; i>=0;i--){
			
			if(!Character.isWhitespace(s.charAt(i))){
				
				sb2.append(s.charAt(i));
				
			}
			if(Character.isWhitespace(s.charAt(i))||i==0) {
				
				sb1.append(sb2.reverse());	
				
				sb2=new StringBuffer();
				if(i!=0)sb1.append(" ");
							
			}
			
		}
		System.out.println(s.length());
		System.out.println(sb1.length());
		assert sb1.length()==s.length():"different lenght";
		
		System.out.println(sb1);
		
	}
	
	/*
	* Write an efficient function to find the first nonrepeated character in a
    * string. For instance, the first nonrepeated character in “total” is 'o' and the first
    * nonrepeated character in “teeter” is 'r'.Discuss the efficiency of your algorithm
	*
	 * @param st
	 * @return
	 */
	public static String FNRC(String st){
		/**
		 * Time complexity is O(N^2)
		 */
		char c;
		boolean found;
		HashSet hs=new HashSet();
		for(int i=0;i<st.length();i++){
			c=st.charAt(i);
			found=false;
			if(i==st.length()-1){
				if(!hs.contains(Character.toString(c))){
					return Character.toString(c);
				}else{
					return null;
				}
			}
			
			for(int k=i+1;k<st.length();k++){
				if(c==st.charAt(k)){
					found=true;
					hs.add(Character.toString(c));
					break;
				}
								
			}
			if((found==false)&&(!hs.contains(Character.toString(c)))) return Character.toString(c);
		}
		
		return null;
	}
	/*
	* Write an efficient function to find the first nonrepeated character in a
    * string. For instance, the first nonrepeated character in “total” is 'o' and the first
    * nonrepeated character in “teeter” is 'r'.Discuss the efficiency of your algorithm
	*
	 * @param st
	 * @return
	 */
	public static Character FNRC2(String st){
		/**
		 * Time complexity is O(N)
		 */
		LinkedHashMap<Character,Integer> lhs=new LinkedHashMap<>();
		
		
		for(int i=0;i<st.length();i++){
			
			if(!lhs.containsKey(st.charAt(i))){
				//System.out.println(st.charAt(i));
				lhs.put(st.charAt(i), new Integer(1));
			}else{
				//System.out.println(lhs.get(Character.toString(st.charAt(i))));
			   lhs.put(st.charAt(i), new Integer(1+lhs.get(st.charAt(i))));
			}
		}
		
		for(Map.Entry<Character, Integer> m: lhs.entrySet()){
			
			if(m.getValue()==1) return m.getKey();
			
		}			
	
	return null;
	
	}
	/**
	 * Write a method to decide if two strings are anagrams or not
	 * @param st
	 * @return
	 */
	 
	public static boolean anagramme(String st){
		return true;
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
	/*	double x=33;
		char c='/';
		System.out.println((char)x);
		System.out.println(2.5%1);
		System.out.println(Math.abs(5));
		System.out.println(NumbSq(12));
	CustumFibo(00);	*/
		
		/*
		int[] iC=new int[6];
				assert iC.length==5: "bad array";
				System.out.println(iC.length);*/
		//System.out.println((new Random()).nextInt(5)+1);
		//permuteStrings();
		//String k="Do or do not, there is no try.";
		//String[] r={"o"};
		//System.out.println(r.length);
		//char[] cc=k.toCharArray();
		//char c=(char)299;
	//	System.out.println();
		//reverse(k);
		/*
		String s="sdofh";
		boolean[] b= new boolean[256];
		int x=s.charAt(1);
		System.out.println(FNRC2("pksoqokoppd"));
		
		System.out.println((char)126); */
		
		//convert int to its corresponding ASCII char
				System.out.println((char)192);
				int xx='d';
				System.out.println(xx=' ');
	}

}
