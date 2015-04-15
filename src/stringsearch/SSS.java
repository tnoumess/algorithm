/**
 * 
 */
package stringsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author Thierry Edson Noumessi
 *
 * @date Apr 13, 2015
 * @12:43:47 PM
 * @SSS.java
 */
public class SSS {

	/**
	 * Brute force search
	 * @param pattern
	 * @param txt
	 * @return
	 */
	public static int BFS(String pattern, StringBuilder txt){
		
		int M=pattern.length();
		int N=txt.length();
		
		for(int i=0;i<=N-M;i++){
			int j;
			for(j=0;j<M;j++)
				if(txt.charAt(i+j)!=pattern.charAt(j))
					 break;
			if(j==M) return i;
		}
		return -1;
		
	}
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		 URL oracle = new URL("http://www.worldwordweb.us/");
		 
	        BufferedReader in = new BufferedReader(
	        new InputStreamReader(oracle.openStream()));
	        StringBuilder s=new StringBuilder();
	        String inputLine;
	        while ((inputLine = in.readLine()) != null){
	            //System.out.println(inputLine);
	            s=s.append(inputLine);
	            
	        }in.close();
			        
	        System.out.println(s);
	       
	        System.out.println(SSS.BFS("/heads", s));
		
	}

}
