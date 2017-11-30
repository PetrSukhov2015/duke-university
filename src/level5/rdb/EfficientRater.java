
/**
 * Write a description of class Rater here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

package level5.rdb;
import java.util.*;

public class EfficientRater implements Rater{
	private String myID;
    private HashMap<String, Rating> myRatings;

    public HashMap<String, Rating> getMyRatings() {
		return myRatings;
	}

	public void setMyRatings(HashMap<String, Rating> myRatings) {
		this.myRatings = myRatings;
	}

	public EfficientRater(String id) {
        myID = id;
        myRatings = new HashMap<String, Rating>();
    }

    public void addRating(String item, double rating) {
        myRatings.put(item, new Rating(item,rating));
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
	public ArrayList<Rating> getMyRatings2() {
		// TODO Auto-generated method stub
		return null;
	}


}
