
/**
 * Write a description of class MarkovZero here.
 * 
 * @author Duke Software
 * @version 1.0
 */
package level4.text.interfaces;
import java.util.ArrayList;
import java.util.Random;

public class MarkovOne extends AbstractMarkovModel{
    
	public MarkovOne() {
		myRandom = new Random();
	}

	
	public void setRandom(int seed){
		myRandom = new Random(seed);
	}
	public void setTraining(String s){
		myText = s.trim();
	}
	public String getRandomText(int numChars){	
		//check for negative scen
		int t=0;
		if (myText == null){
			return "";
		}
		//create output String builder
		StringBuilder sb = new StringBuilder();
		
		// create first letter for output
		int index = myRandom.nextInt(myText.length()-1);
		String key= myText.substring(index,index+1);
		sb.append(key);
		
		//loop through characters
		for(int k=0; k < numChars; k++){
			
			//get all leters after character
			ArrayList<String> follows= getFollows(key);
			if (0==follows.size() ) {
				break;
			}
			
			//match one char
			index = myRandom.nextInt(follows.size());
			String next = follows.get(index);
			sb.append(next);
			key=next;
			//System.out.println(myText.charAt(index));
		}
		
		return sb.toString();
	}
	
	

}
