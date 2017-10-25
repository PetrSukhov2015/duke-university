
/**
 * Find out how many times each word occurs, and
 * in particular the most frequently occurring word.
 * 
 * @author Duke Software Team
 * @version 1.0
 */
package level3.cc;
import edu.duke.*;
import java.util.ArrayList;

public class CharactersInPlay {
    private ArrayList<String> myWords;
    private ArrayList<Integer> myFreqs;
    
    public CharactersInPlay() {
        myWords = new ArrayList<String>();
        myFreqs = new ArrayList<Integer>();
    }
    public void update(String person){
    	int ind = myWords.indexOf(person);
    	if(-1 == ind){
    		myWords.add(person);
    		myFreqs.add(1);
    	}else{
    		int freq = myFreqs.get(ind);
            myFreqs.set(ind,freq+1);
    	}
    }
    
    
    
    public void findAllCharacters (){
        myWords.clear();
        myFreqs.clear();
        
        FileResource resource = new FileResource("D:\\duke\\level3\\CommonWords\\data\\likeit.txt");
        
        for(String l : resource.lines()){
        	//System.out.println(l);
        	int ind = l.indexOf('.'); 
        	if (-1 != ind ){
        		String actor= l.substring(0, ind);
        		update(actor);
        		//System.out.println(actor);
        	}
        }
    }
    public void charactersWithNumParts (int num1, int num2){
    	System.out.println("between "+num1+" and "+num2);
		
    	for (int k=0; k< myFreqs.size(); k++){
    		int tmpN=myFreqs.get(k);
    		if ( num1 <= tmpN && tmpN <= num2){
    			System.out.println(myFreqs.get(k)+" "+ myWords.get(k));
    		}
    	}
    }
    public void tester(){
    	findAllCharacters();
        System.out.println("# unique words: "+myWords.size());
        int index = findMax();
        System.out.println("max word/freq: "+myWords.get(index)+" "+myFreqs.get(index));
        for (int k=0; k<myWords.size(); k++){
        	//System.out.println(myFreqs.get(k)+" "+ myWords.get(k));
        }
        charactersWithNumParts(10,15);
    }
    public int findMax(){
        int max = myFreqs.get(0);
        int maxIndex = 0;
        for(int k=1; k < myFreqs.size(); k++){
            if (myFreqs.get(k) > max){
                max = myFreqs.get(k);
                maxIndex = k;
            }
        }
        //System.out.println(max);
        return maxIndex;
    }
}
