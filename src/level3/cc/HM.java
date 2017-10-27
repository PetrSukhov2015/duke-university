package level3.cc;
import java.util.*;
public class HM {

	private static HashMap<String, Integer > map= new HashMap<String, Integer>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String dna = "CGTTCAAGTTCAA";
		buildCodonMap(2,dna);
		getMostCommonCodon();
	}
	
	public static void buildCodonMap (int sInd, String dna){
		String key="";

		for (int k=sInd; k<dna.length()-2; k+=3){
			key=dna.substring(k,k+3);
			if ( !map.containsKey(key)){
				map.put(key, 1);
			}else{
				map.put(key, map.get(key) + 1);
			}
			//System.out.println(tmp);
		}
	}
	
	public static void getMostCommonCodon (){
		String maxK="";
		int maxV=-1;
		
		for (String key : map.keySet()) {
			System.out.println(key+" "+map.get(key));		    
			if (maxV < map.get(key)){
				maxV = map.get(key);
				maxK=key;
				
			}
		    
		}
		if (-1 != maxV){
			System.out.println("key, " + maxK + " value " + maxV);
		}
		
		
	}

}
