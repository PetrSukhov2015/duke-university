
/**
 * Write a description of class MarkovZero here.
 * 
 * @author Duke Software
 * @version 1.0
 */
package level4.text.interfaces;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class EfficientMarkovModel extends AbstractMarkovModel{
    private int numCharToPredictNextCh=0;
	private HashMap<String, ArrayList<String>> hm = new HashMap<String, ArrayList<String>>();
	public EfficientMarkovModel() {
		myRandom = new Random();
	}
	
	public EfficientMarkovModel( int ch, int seed) {
		myRandom = new Random(seed);
		numCharToPredictNextCh = ch;
	}
	public EfficientMarkovModel( int ch) {
		myRandom = new Random();
		numCharToPredictNextCh = ch;
	}
	
	public void setTraining(String s){
		myText = s.trim();
	}
	
	public String getRandomText(int numChars){	
		//check for negative scen
		if (myText == null){
			return "";
		}
		
		//create output String builder
		StringBuilder sb = new StringBuilder();
		
		// create first letter for output
		int index = myRandom.nextInt(myText.length()-numCharToPredictNextCh);
		String key= myText.substring(index,index+numCharToPredictNextCh);
		sb.append(key);
		
		//loop through characters
		for(int k=0; k < numChars-numCharToPredictNextCh; k++){
			
			//get all leters after character
			ArrayList<String> follows= newGetFollows(hm,key);
			if (null == follows || 0==follows.size() ) {
				break;
			}
			
			//match one char
			index = myRandom.nextInt(follows.size());
			String next = follows.get(index);
			sb.append(next);
			key=key.substring(1)+next.substring(0, 1);
			//System.out.println(myText.charAt(index));
		}
		
		return sb.toString();
	}
	
	public void buildHashMap(){
		if (0!= numCharToPredictNextCh && myText != null){
			
		
		
		// create first letter for output
			int index = myRandom.nextInt(myText.length()-numCharToPredictNextCh);
			String key= myText.substring(index,index+numCharToPredictNextCh);
			
		
		//loop through characters
			System.out.println(myText.length());
			for(int k=0; k < myText.length()-numCharToPredictNextCh; k++){
			
			//get all leters after character
				ArrayList<String> follows= getFollows(key);
				System.out.println("k="+k+" num:"+follows.size());
				if (0==follows.size() ) {
					break;
				}
				hm.put(key,follows);
			//match one char
				index = myRandom.nextInt(follows.size());
				String next = follows.get(index);
				//System.out.println(next);
				key=key.substring(1)+next;
				//System.out.println(key.length());
			//System.out.println(myText.charAt(index));
			}
		}
		
		
		
	}
	public void printHM(){
		for (HashMap.Entry<String, ArrayList<String>> entry : hm.entrySet()) {
		    System.out.println("size"+entry.getValue().size()+" "+entry.getKey()+" : "+entry.getValue());
		}
	}
	public void printLagestLists(){
		HashMap <String, ArrayList<String>> tmp = new HashMap<String,ArrayList<String>>();
		int maxS=0;
		for (HashMap.Entry<String, ArrayList<String>> entry : hm.entrySet()) {
			if (maxS < entry.getValue().size() ){
				maxS = entry.getValue().size();
			}
		}
		for (HashMap.Entry<String, ArrayList<String>> entry : hm.entrySet()) {
			if (maxS == entry.getValue().size() ){
				System.out.println("size"+entry.getValue().size()+" "+entry.getKey()+" : "+entry.getValue());
			}
		}
	}

	public void printNumKeysHM() {
		System.out.println(hm.size());
		
	}

	@Override
	public void setRandom(int j) {
		// TODO Auto-generated method stub
		
	}
	

}
