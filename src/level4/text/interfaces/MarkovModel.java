
/**
 * Write a description of class MarkovZero here.
 * 
 * @author Duke Software
 * @version 1.0
 */
package level4.text.interfaces;
import java.util.ArrayList;
import java.util.Random;

public class MarkovModel extends AbstractMarkovModel{
    private int numCharToPredictNextCh;
	
	public MarkovModel() {
		myRandom = new Random();
	}
	
	public MarkovModel(int ch) {
		myRandom = new Random();
		numCharToPredictNextCh = ch;
	}

	
	public void setRandom(int seed){
		myRandom = new Random(seed);
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
			ArrayList<String> follows= getFollows(key);
			System.out.println(follows.size());
			if (0==follows.size() ) {
				break;
			}
			
			//match one char
			index = myRandom.nextInt(follows.size());
			String next = follows.get(index);
			sb.append(next);
			key=key.substring(1)+next;
			//System.out.println(myText.charAt(index));
		}
		
		return sb.toString();
	}
	/*
	public ArrayList<String> getFollows(String key){
		
		int kl=key.length();
		ArrayList<String> res = new ArrayList<String>();
		for (int i =0; i<myText.length()-kl; i++){
			if ( key.equals(myText.substring(i,i+kl)) ){
				String tmp = myText.substring(i+kl,i+kl+1);
				res.add(tmp);
			}
		}
		//
		//int size=res.size();
		//System.out.println("size is: "+size);
		//for (String s: res){			System.out.println(s);		}
		return res;
	}*/
}
