/**
 * 4.4
 * The mode of a set of numbers is the number that occurs most frequently in the set.
 * The set (4,6,2,4,3,1) has a mode of 4. Give an efficient and correct algorithm to compute
 * the mode of a set of n numbers.
 */
package exercices;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Thierry Edson Noumessi
 *
 * @date Apr 6, 2015
 * @5:12:09 PM
 * @Sort2.java
 */
public class Sorting2 {
	public static int sort2(int[] a){
		 HashMap<Integer, Integer> h=new HashMap<Integer, Integer>();
		for(int i=0;i<a.length;i++){
			if(h.containsKey(a[i])){
				h.put(a[i], h.get(a[i]) + 1);;
			}else{
				System.out.println("initial:"+a[i]);
				h.put(a[i], 1);
			}
		}
		int max=0;
		int maxkey=0;
		for(Map.Entry<Integer, Integer> entry:h.entrySet()){
			
			if(entry.getValue()>=max){
				max=entry.getValue();
				maxkey=entry.getKey();
				
			}
		}
		System.out.println(h.toString());
		return maxkey;
	} 

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a={4,5,8,6,857,19,19,6,6,6,7,7,7,84,20};
//sort2(a);
System.out.println();
System.out.println(sort2(a));
	}

}
