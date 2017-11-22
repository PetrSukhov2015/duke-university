package level5.interfaces;
/**
 * Write a description of SecondRatings here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;
import java.util.Map.Entry;

import level5.interfaces.Movie;
import level5.interfaces.Rater;
import level5.interfaces.Rating;

public class ThirdRatings {
	private ArrayList<PlainRater> myRaters;
	public static void main(String[] args){
    	SecondRatings sr = new SecondRatings();
    	//System.out.println("i am here");
    }
    public ThirdRatings() {
        this("rating.csv");
    	// default constructor
    	//this("D:\\duke\\level5\\StepOneStarterProgram\\data\\ratedmoviesfull3.csv", 
    	//		"D:\\duke\\level5\\StepOneStarterProgram\\data\\ratings.csv");
    	//String ratedMovie= "D:\\duke\\level5\\StepOneStarterProgram\\data\\ratedmoviesfull3.csv";
        //String ratingMovie = "D:\\duke\\level5\\StepOneStarterProgram\\data\\ratings.csv";
    	//this("ratedmoviesfull.csv", "ratings.csv");
        
    }

	public ThirdRatings(String ratingsfile) {
		// TODO Auto-generated constructor stub
		myRaters = FirstRatings.loadRaters(ratingsfile);
		//FirstRatings fr = new FirstRatings();
		
		
	}
	public ArrayList<Rating> getAverageRatings(int ratMin) {
		ArrayList<Rating> ratList = new ArrayList<Rating>();
		//ratList=null;
		//HashMap<String, ArrayList<Double>> mapID = new HashMap<String, ArrayList<Double>>(); 
		ArrayList<String> ids = new ArrayList<String>();
		
		for (PlainRater rater:myRaters){
			
			//ArrayList<Rating> ratList1 = rater.getMyRatings();
			for (Rating r: rater.getMyRatings()){
					//System.out.print(r.getItem()+" "+r.getValue() +"\n");
				//if not in tmp list then add
				if ( !ids.contains(r.getItem()) ){
					ids.add(r.getItem());
					double tmp = this.getAverageByID(r.getItem(), ratMin);
					//System.out.println(r.getItem()+" "+tmp );
					Rating theRating = new Rating(r.getItem(), tmp);
					//System.out.println(theRating);
					
					ratList.add(theRating);
					//System.out.println(ratList);
					
					
				}
			}

		}
		
		return ratList;
		
	}

	
	

    
}
