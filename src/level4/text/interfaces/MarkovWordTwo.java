
/**
 * Write a description of class MarkovWordOne here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
package level4.text.interfaces;
import java.util.*;

public class MarkovWordTwo implements IMarkovModel {
    
	
	private String[] myText;
    private Random myRandom;
    
    public MarkovWordTwo() {
        myRandom = new Random();
    }
    
    public void setRandom(int seed) {
        myRandom = new Random(seed);
    }
    
    public void setTraining(String text){
		myText = text.split("\\s+");
	}
	
	public String getRandomText(int numWords){
		StringBuilder sb = new StringBuilder();
		int index = myRandom.nextInt(myText.length-1);  // random word to start with
		String key = myText[index];
		String key2= myText[index+1];
		//String key = "this";
		//String key2= "is";
		
		sb.append(key);
		sb.append(" ");
		sb.append(key2);
		sb.append(" ");
		for(int k=0; k < numWords-1; k++){
		    ArrayList<String> follows = getFollows(key,key2);
		    
		    //for(String f:follows){		    	System.out.println(f);		    }
		    
		    if (follows.size() == 0) {
		        break;
		    }
			index = myRandom.nextInt(follows.size());
			String next = follows.get(index);
			sb.append(next);
			sb.append(" ");
			key=key2;
			key2 = next;
			
		}
		
		return sb.toString().trim();
	}
	static int indexOf(String[] words, String target, String target2, int start){
		for (int k=start; k<words.length; k++){
			if (words[k].equals(target)  && words[k+1].equals(target2)){
				return k+1;
			}
		}
		return -1;
		
	}
	private ArrayList<String> getFollows(String key, String key2) {
	    ArrayList<String> follows = new ArrayList<String>();
	    int pos=0;
	    while (pos<myText.length){
	    	int start = indexOf(myText,key, key2, pos);
	    	if (-1==start){break;}
	    	if ( (start+key.length()) >myText.length){break;}
	    	String next = myText[start+1];
	    	follows.add(next);
	    	pos=start+key.length()+1;
	    	//key=myText[pos];
	    	
	    }
	    return follows;
    }

}
