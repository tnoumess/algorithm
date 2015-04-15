/**
 * 4.3
 * Assume that we are given n pairs of items as input,
 *  where the first item is a number and the second item is one of three colors (red, blue, or yellow). 
 *  Further assume that the items are sorted by number. Give an O(n) algorithm to sort the items by color 
 *  (all reds before all blues before all yellows) such that the numbers for identical colors stay sorted.
 *   For example:  (1,blue), (3,red), (4,blue), (6,yellow), (9,red) should become (3,red), (9,red), (1,blue), (4,blue), (6,yellow). 
 */
package exercices;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Thierry Edson Noumessi
 *
 * @date Apr 6, 2015
 * @4:15:26 PM
 * @Sorting1.java
 */
public class Sorting1 {
	
	public static void Sort1(HashMap<Integer , String> h){
		/**
		 * LinkedHashMap preserves the order over time
		 */
		Map<Integer, String> red=new LinkedHashMap<Integer,String>();
		Map<Integer, String> blue=new LinkedHashMap<Integer,String>();
		Map<Integer, String> yellow=new LinkedHashMap<Integer,String>();
		
		for(Map.Entry<Integer, String> entry:h.entrySet()){
			
			if(entry.getValue()=="red") red.put(entry.getKey(), entry.getValue());
			if(entry.getValue()=="blue") blue.put(entry.getKey(), entry.getValue());
			if(entry.getValue()=="yellow") yellow.put(entry.getKey(), entry.getValue());
		}
		System.out.print(red.toString());
		System.out.print(blue.toString());
		System.out.print(yellow.toString());
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HashMap<Integer , String> h=new HashMap<Integer,String>();
		h.put(1, "blue");h.put(3,"red"); h.put(4,"blue"); h.put(6,"yellow");h.put(9, "red");
		System.out.println("Initial list"+h.toString());
		System.out.print("Sorted List:");

		Sort1(h);
		
	}

}
