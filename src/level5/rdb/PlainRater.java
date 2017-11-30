
/**
 * Write a description of class Rater here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

package level5.rdb;
import java.util.*;
import level5.rdb.Rater;

public class PlainRater implements  Rater{
    private String myID;
    private ArrayList<Rating> myRatings;

    //public ArrayList<Rating> getMyRatings() {
	//	return myRatings;
	//}

	public void setMyRatings(ArrayList<Rating> myRatings) {
		this.myRatings = myRatings;
	}

	public PlainRater(String id) {
        myID = id;
        myRatings = new ArrayList<Rating>();
    }

    public void addRating(String item, double rating) {
        myRatings.add(new Rating(item,rating));
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

	//@Override
	//public HashMap<String, Rating> getMyRatings2() {
	//	// TODO Auto-generated method stub
	//	return null;
	//}

	@Override
	public ArrayList<Rating> getMyRatings2() {
		// TODO Auto-generated method stub
		return myRatings;
	}

	@Override
	public HashMap<String, Rating> getMyRatings() {
		// TODO Auto-generated method stub
		return null;
	}




}
