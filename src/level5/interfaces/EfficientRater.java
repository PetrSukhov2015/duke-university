
/**
 * Write a description of class Rater here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

package level5.interfaces;
import java.util.*;

public class EfficientRater implements Rater{
    private String myID;
    //private HashMap<String,Rating> myRatings;
    private ArrayList<Rating> myRatings;

    //public ArrayList<Rating> getMyRatings() {
	//	return myRatings;
	//a}

	//public void setMyRatings(HashMap<String,Rating> myRatings) {		this.myRatings = myRatings;}

	public EfficientRater(String id) {
        myID = id;
        //myRatings = new HashMap<String,Rating>();
        myRatings = new ArrayList<Rating>();
    }

    public void addRating(String item, double rating) {
        //myRatings.put(item, new Rating(item,rating));
    	myRatings.add(new Rating(item,rating));
    }

    public boolean hasRating2(String item) {
    	if (myRatings.contains(item)){
    		return true;
    	}
    	return false;
    	
        //for(int k=0; k < myRatings.size(); k++){
        //    if (myRatings.get(k).getItem().equals(item)){
        //        return true;
        //    }
        //}
        
        //return false;
    }
    public boolean hasRating(String item) {
        for(int k=0; k < myRatings.size(); k++){
            if (myRatings.get(k).getItem().equals(item)){
                return true;
            }
        }
        
        return false;
    }
    public String getID() {
        return myID;
    }

    public double getRating(String item) {
        for(int k=0; k < myRatings.size(); k++){
            if (myRatings.get(k).getItem().equals(item)){
                return myRatings.get(k).getValue();
            }
        }
        
        return -1;
    }

    public int numRatings() {
        return myRatings.size();
    }

    public ArrayList<String> getItemsRated() {
        ArrayList<String> list = new ArrayList<String>();
        for(int k=0; k < myRatings.size(); k++){
            list.add(myRatings.get(k).getItem());
        }
        
        return list;
    }

	@Override
	public ArrayList<Rating> getMyRatings() {
		// TODO Auto-generated method stub
		return null;
	}


}
